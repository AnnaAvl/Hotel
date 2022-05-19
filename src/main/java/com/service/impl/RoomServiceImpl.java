package com.service.impl;

import com.repository.RoomRepository;
import com.entity.Room;
import com.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository repository;

    @Override
    public Room read(long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Room> read() {
        return repository.findAll();
    }

    @Override
    public void save(Room entity) {
        repository.save(entity);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Room entity) {
        Room room = repository.findById(entity.getId()).orElseThrow(IllegalArgumentException::new);
        room.setBedsAmount(entity.getBedsAmount());
        room.setBookings(entity.getBookings());
        room.setCleaning(entity.isCleaning());
        room.setDailyCost(entity.getDailyCost());
        repository.save(room);
    }

    @Override
    public List<Room> readByPrice(double begin, double end) {
        return repository.findByDailyCostBetween(begin, end);
    }
}
