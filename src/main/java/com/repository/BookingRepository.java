package com.repository;

import com.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByClient(String surname);
    List<Booking> findByPromotion(long id);
    List<Booking> findByRoom(long id);
}
