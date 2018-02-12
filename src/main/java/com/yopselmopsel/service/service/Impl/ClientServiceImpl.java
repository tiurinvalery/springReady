package com.yopselmopsel.service.service.Impl;

import com.yopselmopsel.service.model.Client;
import com.yopselmopsel.service.repo.ClientRepository;
import com.yopselmopsel.service.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client findClientByName(String name) {

       return  clientRepository.findByName(name);
    }

    @Override
    public Client findClientById(Long id) {
        return clientRepository.findClientById(id);
    }

    @Override
    public void createClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void createClients(List<Client> clients) {
        clientRepository.saveAll(clients);
    }

    @Override
    public void updateClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void updateClients(List<Client> clients) {
        clientRepository.saveAll(clients);
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    @Override
    public void deleteClients(List<Client> clients) {
        clientRepository.deleteAll(clients);
    }

    @Override
    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public boolean isClientExist(String name) {
        boolean flag = false;
        Client client = findClientByName(name);
        if(client != null) flag = true;
        return flag;
    }

    @Override
    public void deleteAllClient() {
        clientRepository.deleteAll();
    }
}
