package com.yopselmopsel.service.service;

import com.yopselmopsel.service.model.Client;

import java.util.List;

public interface ClientService {
    Client findClientByName(String name);
    Client findClientById(Long id);
    void createClient(Client clients);
    void createClients(List<Client> client);
    void updateClient(Client client);
    void updateClients(List<Client> clients);
    void deleteClient(Client client);
    void deleteClients(List<Client> clients);
    List<Client> findAllClient();

    //logic
    boolean isClientExist(String name);
    void deleteAllClient();
}
