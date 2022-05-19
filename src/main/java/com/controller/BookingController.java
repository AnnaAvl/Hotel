package com.controller;


import com.entity.Booking;
import com.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/booking")
public class BookingController extends AbstractController<Booking> {
    @Autowired
    private BookingService service;

    @Override
    public BookingService getService() {
        return service;
    }

    @GetMapping("/surname/{surname}")
    public ResponseEntity<List<Booking>> getBookingByClient(@PathVariable String surname) {
        List<Booking> bookings = service.readByClient(surname);
        if (bookings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookings, headers, HttpStatus.OK);
    }

    @GetMapping("/promotion/{id}")
    public ResponseEntity<List<Booking>> getBookingByPromotion(@PathVariable Integer id) {
        List<Booking> bookings = service.readByPromotion(id);
        if (bookings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookings, headers, HttpStatus.OK);
    }

    @GetMapping("/room/{number}")
    public ResponseEntity<List<Booking>> getBookingByRoom(@PathVariable Integer number) {
        List<Booking> bookings = service.readByRoom(number);
        if (bookings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookings, headers, HttpStatus.OK);
    }
}
