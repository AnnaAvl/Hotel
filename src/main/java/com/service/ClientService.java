package com.service;

import com.entity.Client;

import java.util.List;

public interface ClientService extends Service<Client>{
    List<Client> readBySurname(String surname);
}
