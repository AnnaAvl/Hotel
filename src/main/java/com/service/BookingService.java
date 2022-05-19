package com.service;

import com.entity.Booking;

import java.util.List;

public interface BookingService extends Service<Booking> {
    List<Booking> readByClient(String surname);
    List<Booking> readByPromotion(long id);
    List<Booking> readByRoom(long id);
}
