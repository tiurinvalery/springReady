package com.yopselmopsel.service.repo;

import com.yopselmopsel.service.model.Good;
import com.yopselmopsel.service.model.Order;
import com.yopselmopsel.service.model.PartOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartOrderRepository extends CrudRepository<PartOrder,Long> {
    PartOrder findPartOrderById(Long id);
    PartOrder findPartOrderByNumberAndGoodAndOrder(int number, Good good, Order order);
}
