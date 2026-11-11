package com.ticketflow.booking_service.dto;

public class EventResponse {
    private Long id;
    // Ajoutez ici les autres attributs retournés par l'Event-Service (ex: title, date, etc.)

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}