package com.yopselmopsel.service.repo;

import com.yopselmopsel.service.model.Client;
import com.yopselmopsel.service.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
    Order findOrderById(Long id);
    Order findOrderByPriceAndClient(Long price, Client client);
    List<Order> findAll();
}
