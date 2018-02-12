package com.yopselmopsel.service.service.Impl;

import com.yopselmopsel.service.model.Good;
import com.yopselmopsel.service.model.Order;
import com.yopselmopsel.service.model.PartOrder;
import com.yopselmopsel.service.repo.PartOrderRepository;
import com.yopselmopsel.service.service.PartOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class PartOrderServiceImpl implements PartOrderService {

    @Autowired
    private PartOrderRepository partOrderRepository;
    @Override
    public void createPartOrder(PartOrder partOrder) {
        partOrderRepository.save(partOrder);
    }

    @Override
    public void createPartOrders(List<PartOrder> partOrders) {
        partOrderRepository.saveAll(partOrders);
    }

    @Override
    public void updatePartOrder(PartOrder partOrder) {
        partOrderRepository.save(partOrder);
    }

    @Override
    public void updatePartOrders(List<PartOrder> partOrders) {
        partOrderRepository.saveAll(partOrders);
    }

    @Override
    public void deletePartOrder(PartOrder partOrder) {
        partOrderRepository.delete(partOrder);
    }

    @Override
    public void deletePartOrders(List<PartOrder> partOrders) {
        partOrderRepository.deleteAll(partOrders);
    }

    @Override
    public PartOrder findPartOrderById(Long id) {
        return partOrderRepository.findPartOrderById(id);
    }

    @Override
    public PartOrder findPartOrderByNumberAndGoodAndOrder(int number, Good good, Order order) {
        return partOrderRepository.findPartOrderByNumberAndGoodAndOrder(number,good, order);
    }
}
