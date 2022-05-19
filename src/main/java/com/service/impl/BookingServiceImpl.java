package com.service.impl;


import com.entity.Booking;
import com.repository.BookingRepository;
import com.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository repository;

    @Override
    public Booking read(long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Booking> read() {
        return repository.findAll();
    }

    @Override
    public void save(Booking entity) {
        repository.save(entity);
    }

    @Override
    public void delete(long id) {
        repository.deleteById((long)id);
    }

    @Override
    public void edit(Booking entity) {
        Booking booking = repository.findById(entity.getId()).orElseThrow(IllegalArgumentException::new);
        booking.setCheckInDate(entity.getCheckInDate());
        booking.setCheckOutDate(entity.getCheckOutDate());
        booking.setClient(entity.getClient());
        booking.setPromotion(entity.getPromotion());
        booking.setRoom(entity.getRoom());
        repository.save(booking);
    }

    @Override
    public List<Booking> readByClient(String surname) {
        return repository.findByClient(surname);
    }

    @Override
    public List<Booking> readByPromotion(long id) {
        return repository.findByPromotion(id);
    }

    @Override
    public List<Booking> readByRoom(long id) {
        return repository.findByRoom(id);
    }
}
