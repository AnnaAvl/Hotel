package com.controller;


import com.entity.Room;
import com.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/room")
public class RoomController extends AbstractController<Room> {
    @Autowired
    private RoomService service;

    @Override
    public RoomService getService() {
        return service;
    }

    @GetMapping("/price/from{begin}to{end}")
    public ResponseEntity<List<Room>> getByPrice(@PathVariable double begin, @PathVariable double end) {
        List<Room> rooms = service.readByPrice(begin, end);
        if (rooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rooms, headers, HttpStatus.OK);
    }
}
