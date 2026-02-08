package com.portfolio.backend.service;

import java.util.List;

import com.portfolio.backend.entity.Client;

public interface ClientService {

    Client createClient(Client client);

    List<Client> getAllClients();

    Client getClientById(Long id);

    void deleteClient(Long id);
}

