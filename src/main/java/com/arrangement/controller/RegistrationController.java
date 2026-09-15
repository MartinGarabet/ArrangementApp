package com.arrangement.controller;

import com.arrangement.model.Event;
import com.arrangement.model.Registration;
import com.arrangement.repository.EventRepository;
import com.arrangement.repository.RegistrationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events/{eventId}/registrations")
public class RegistrationController {

    private final RegistrationRepository registrationRepository;
    private final EventRepository eventRepository;

    public RegistrationController(RegistrationRepository registrationRepository, EventRepository eventRepository) {
        this.registrationRepository = registrationRepository;
        this.eventRepository = eventRepository;
    }

    @GetMapping
    public List<Registration> getRegistrationsForEvent(@PathVariable Long eventId) {
        return registrationRepository.findByEventId(eventId);
    }

    @PostMapping
    public Registration register(@PathVariable Long eventId, @RequestBody Registration registration) {
        Optional<Event> eventOpt = eventRepository.findById(eventId);
        if (eventOpt.isEmpty()) {
            throw new RuntimeException("Fant ikke arrangement med id " + eventId);
        }

        Event event = eventOpt.get();
        registration.setEvent(event);

        long confirmedCount = registrationRepository.countByEventIdAndStatus(eventId, "CONFIRMED");

        if (confirmedCount < event.getCapacity()) {
            registration.setStatus("CONFIRMED");
        } else {
            registration.setStatus("WAITLISTED");
        }

        return registrationRepository.save(registration);
    }
}