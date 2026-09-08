package com.arrangement.controller;

import com.arrangement.model.Registration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/events/{eventId}/registrations")
public class RegistrationController {

    private final List<Registration> registrations = new ArrayList<>();
    private long nextId = 1;

    @GetMapping
    public List<Registration> getRegistrationsForEvent(@PathVariable Long eventId) {
        return registrations.stream()
                .filter(r -> r.getEventId().equals(eventId))
                .collect(Collectors.toList());
    }

    @PostMapping
    public Registration register(@PathVariable Long eventId, @RequestBody Registration registration) {
        registration.setId(nextId);
        nextId++;
        registration.setEventId(eventId);
        registrations.add(registration);
        return registration;
    }
}