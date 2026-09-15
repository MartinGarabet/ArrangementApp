package com.arrangement.controller;

import com.arrangement.model.Event;
import com.arrangement.model.Registration;
import com.arrangement.repository.EventRepository;
import com.arrangement.repository.RegistrationRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RegistrationControllerTest {

    @Test
    void registrationIsConfirmedWhenUnderCapacity() {
        EventRepository eventRepository = mock(EventRepository.class);
        RegistrationRepository registrationRepository = mock(RegistrationRepository.class);

        Event event = new Event(1L, "Testfest", 2);
        when(eventRepository.findById(1L)).thenReturn(Optional.of(event));
        when(registrationRepository.countByEventIdAndStatus(1L, "CONFIRMED")).thenReturn(0L);
        when(registrationRepository.save(any(Registration.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        RegistrationController controller = new RegistrationController(registrationRepository, eventRepository);

        Registration newRegistration = new Registration();
        newRegistration.setParticipantName("Kari");
        newRegistration.setParticipantEmail("kari@example.com");

        Registration result = controller.register(1L, newRegistration);

        assertEquals("CONFIRMED", result.getStatus());
    }

    @Test
    void registrationIsWaitlistedWhenAtCapacity() {
        EventRepository eventRepository = mock(EventRepository.class);
        RegistrationRepository registrationRepository = mock(RegistrationRepository.class);

        Event event = new Event(1L, "Testfest", 2);
        when(eventRepository.findById(1L)).thenReturn(Optional.of(event));
        when(registrationRepository.countByEventIdAndStatus(1L, "CONFIRMED")).thenReturn(2L);
        when(registrationRepository.save(any(Registration.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        RegistrationController controller = new RegistrationController(registrationRepository, eventRepository);

        Registration newRegistration = new Registration();
        newRegistration.setParticipantName("Per");
        newRegistration.setParticipantEmail("per@example.com");

        Registration result = controller.register(1L, newRegistration);

        assertEquals("WAITLISTED", result.getStatus());
    }
}