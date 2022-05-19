package com.service;

import com.entity.Room;

import java.util.List;

public interface RoomService extends Service<Room> {
    List<Room> readByPrice(double begin, double end);
}
