package com.ticketflow.event_service.controllers;

import com.ticketflow.event_service.dto.EventResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/event")
public class EventController {
    @GetMapping("/{id}")
    EventResponse get(@PathVariable Long id) {
        return EventResponse.from(service.get(id));
    }
}