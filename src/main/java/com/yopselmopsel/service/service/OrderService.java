package com.yopselmopsel.service.service;

import com.yopselmopsel.service.model.Client;
import com.yopselmopsel.service.model.Order;
import com.yopselmopsel.service.model.PartOrder;

import java.util.List;
import java.util.Set;

public interface OrderService {
    Order findOrderById(Long id);
    List<Order> findAllOrders();
    void createOrder(Order order);
    void createOrders(List<Order> orders);
    void updateOrder(Order order);
    void updateOrders(List<Order> orders);
    void deleteOrder(Order order);
    void deleteOrders(List<Order> orders);
    Order findOrderByPriceAndClient(Long price, Client client);
    Long getResultPrice(Set<PartOrder> partOrders);
    int getTotalNumberOfGoods(Set<PartOrder> partOrders);
}
