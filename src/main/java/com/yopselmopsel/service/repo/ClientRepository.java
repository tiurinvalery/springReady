package com.yopselmopsel.service.repo;

import com.yopselmopsel.service.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {
    Client findByName(String name);
    Client findClientById(Long id);
    List<Client> findAll();
}
