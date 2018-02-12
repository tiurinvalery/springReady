package com.yopselmopsel.service.service.Impl;

import com.yopselmopsel.service.model.Client;
import com.yopselmopsel.service.model.Order;
import com.yopselmopsel.service.model.PartOrder;
import com.yopselmopsel.service.repo.OrderRepository;
import com.yopselmopsel.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void createOrders(List<Order> orders) {
        orderRepository.saveAll(orders);
    }

    @Override
    public void updateOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void updateOrders(List<Order> orders) {
        orderRepository.saveAll(orders);
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public void deleteOrders(List<Order> orders) {
        orderRepository.deleteAll(orders);
    }

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.findOrderById(id);
    }

    @Override
    public Order findOrderByPriceAndClient(Long price, Client client) {
        return orderRepository.findOrderByPriceAndClient(price,client);
    }

    public Long getResultPrice(Set<PartOrder> partOrders) {
        Long resPrice = 0L;
        for(PartOrder po : partOrders) {
            resPrice = resPrice + po.getTotalPrice();
        }
        return resPrice;
    }

    @Override
    public int getTotalNumberOfGoods(Set<PartOrder> partOrders) {
        int result =0;
        for(PartOrder po:partOrders) {
            result = result + po.getNumber();
        }
        return result;
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }
}
