package com.service.impl;


import com.entity.Client;
import com.repository.ClientRepository;
import com.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository repository;



    @Override
    public Client read(long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Client> read() {
        return repository.findAll();
    }

    @Override
    public void save(Client entity) {
        repository.save(entity);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Client entity) {
        Client client = repository.findById(entity.getId()).orElseThrow(IllegalArgumentException::new);
        client.setName(entity.getName());
        client.setBookings(entity.getBookings());
        client.setBirthday(entity.getBirthday());
        client.setPassport(entity.getPassport());
        client.setPhone(entity.getPhone());
        client.setSurname(entity.getSurname());
        repository.save(client);
    }

    @Override
    public List<Client> readBySurname(String surname) {
        return repository.findBySurname(surname);
    }
}
