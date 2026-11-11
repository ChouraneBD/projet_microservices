package com.ticketflow.booking_service.controller;

import com.ticketflow.booking_service.service.BookingService;
import feign.FeignException;
import feign.RetryableException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@RestControllerAdvice
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/{eventId}")
    public void createBooking(@PathVariable Long eventId) {
        // Appelle le service qui utilise OpenFeign pour vérifier l'événement
        bookingService.validateEvent(eventId);
    }
    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<Void> notFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({RetryableException.class, CallNotPermittedException.class})
    public ResponseEntity<Void> unavailable() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }
}