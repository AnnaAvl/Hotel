package com.controller;


import com.entity.Client;
import com.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController extends AbstractController<Client>{
    @Autowired
    private ClientService service;

    @Override
    public ClientService getService() {
        return service;
    }

    @GetMapping("/surname/{surname}")
    public ResponseEntity<List<Client>> getClientBySurname(@PathVariable String surname) {
        List<Client> clients = service.readBySurname(surname);
        if (clients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clients, headers, HttpStatus.OK);
    }
}
