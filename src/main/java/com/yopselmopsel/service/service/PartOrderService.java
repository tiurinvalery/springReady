package com.yopselmopsel.service.service;

import com.yopselmopsel.service.model.Good;
import com.yopselmopsel.service.model.Order;
import com.yopselmopsel.service.model.PartOrder;

import java.util.List;

public interface PartOrderService {
    PartOrder findPartOrderById(Long id);
    PartOrder findPartOrderByNumberAndGoodAndOrder(int number, Good good, Order order);
    void createPartOrder(PartOrder partOrder);
    void createPartOrders(List<PartOrder> partOrders);
    void updatePartOrder(PartOrder partOrder);
    void updatePartOrders(List<PartOrder> partOrders);
    void deletePartOrder(PartOrder partOrder);
    void deletePartOrders(List<PartOrder> partOrders);

}
