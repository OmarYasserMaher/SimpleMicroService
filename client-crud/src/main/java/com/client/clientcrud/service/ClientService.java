package com.client.clientcrud.service;

import com.client.clientcrud.entity.Client;

import java.util.List;

public interface ClientService {
    Client createClient(Client client);
    Client getClientById(Long id);
    List<Client> getAllClients();
}