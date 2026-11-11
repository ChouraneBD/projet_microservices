package com.ticketflow.event_service.dto;

import com.ticketflow.event_service.entities.Event;

public class EventResponse {
    private Long id;
    private String name;

    public static EventResponse from(Event event) {
        EventResponse dto = new EventResponse();
        dto.setId(event.getId());
        dto.setName(event.getName());
        return dto;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}