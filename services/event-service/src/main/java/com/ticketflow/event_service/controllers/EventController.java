package com.ticketflow.event_service.controllers;

import com.ticketflow.event_service.dto.EventResponse;
import com.ticketflow.event_service.entities.Event;
import com.ticketflow.event_service.services.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public Event create(@RequestBody Event event) {
        return eventService.save(event);
    }

    @GetMapping
    public List<EventResponse> getAll() {
        return eventService.findAll().stream()
                .map(EventResponse::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EventResponse getById(@PathVariable Long id) {
        return EventResponse.from(eventService.findById(id));
    }

    @PutMapping("/{id}")
    public Event update(@PathVariable Long id, @RequestBody Event event) {
        return eventService.update(id, event);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        eventService.delete(id);
    }
}