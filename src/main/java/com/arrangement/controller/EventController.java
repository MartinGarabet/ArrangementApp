package com.arrangement.controller;

import com.arrangement.model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final List<Event> events = new ArrayList<>();
    private long nextId = 1;

    @GetMapping
    public List<Event> getAllEvents() {
        return events;
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        event.setId(nextId);
        nextId++;
        events.add(event);
        return event;
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                return event;
            }
        }
        return null;
    }
}