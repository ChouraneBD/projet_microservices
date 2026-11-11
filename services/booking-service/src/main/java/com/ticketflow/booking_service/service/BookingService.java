package com.ticketflow.booking_service.service;

import com.ticketflow.booking_service.client.EventClient;
import com.ticketflow.booking_service.dto.EventResponse;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final EventClient eventClient;
    public BookingService(EventClient eventClient) {
        this.eventClient = eventClient;
    }
    public void validateEvent(Long eventId) {
        EventResponse event = eventClient.getById(eventId);
// L’appel réussi permet de poursuivre la réservation.
    }
}
