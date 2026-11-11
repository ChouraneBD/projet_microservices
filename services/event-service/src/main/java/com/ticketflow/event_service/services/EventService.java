package com.ticketflow.event_service.services;

import com.ticketflow.event_service.entities.Event;
import com.ticketflow.event_service.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event findById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public Event update(Long id, Event newEvent) {
        Event event = findById(id);
        event.setName(newEvent.getName());
        return eventRepository.save(event);
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}