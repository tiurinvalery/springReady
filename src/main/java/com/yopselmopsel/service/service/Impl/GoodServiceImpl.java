package com.yopselmopsel.service.service.Impl;

import com.yopselmopsel.service.model.Good;
import com.yopselmopsel.service.model.Order;
import com.yopselmopsel.service.model.PartOrder;
import com.yopselmopsel.service.repo.GoodRepository;
import com.yopselmopsel.service.repo.OrderRepository;
import com.yopselmopsel.service.service.GoodService;
import com.yopselmopsel.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodRepository goodRepository;

    @Autowired
    private OrderService orderService;

    @Override
    public void createGood(Good good) {
        goodRepository.save(good);
    }

    @Override
    public void createGoods(List<Good> goods) {
        goodRepository.saveAll(goods);
    }

    @Override
    public void updateGood(Good good) {
        goodRepository.save(good);
    }

    @Override
    public void updateGoods(List<Good> goods) {
        goodRepository.saveAll(goods);
    }

    @Override
    public void deleteGood(Good good) {
        goodRepository.delete(good);
    }

    @Override
    public void deleteGoods(List<Good> goods) {
        goodRepository.deleteAll(goods);
    }

    @Override
    public Good findGoodById(Long id) {
        return goodRepository.findGoodById(id);
    }

    @Override
    public Good findGoodByName(String name) {
        return goodRepository.findGoodByName(name);
    }

    @Override
    public List<Good> findGoodsByNameLike(String name) {
        return goodRepository.findGoodsByNameLike(name);
    }

    @Override
    public List<Good> findAllGoods() {
        return goodRepository.findAll();
    }

    @Override
    public List<Good> findAllGoodsInOrder(Long orderId) {
        List<Good> goodsInOrder = new ArrayList<>();
        Order searchOrder  = orderService.findOrderById(orderId);
        for(PartOrder po : searchOrder.getOrders()) {
            Good getsGood = po.getGood();
            getsGood.setNumber(po.getNumber());
            goodsInOrder.add(getsGood);
        }
        return goodsInOrder;
    }


}