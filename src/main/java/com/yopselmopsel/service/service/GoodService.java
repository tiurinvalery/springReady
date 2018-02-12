package com.yopselmopsel.service.service;

import com.yopselmopsel.service.model.Good;
import com.yopselmopsel.service.model.PartOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodService {
    //Crud
    Good findGoodByName(String name);
    Good findGoodById(Long id);
    List<Good> findGoodsByNameLike(String name);
    void createGood(Good good);
    void createGoods(List<Good> goods);
    void updateGood(Good good);
    void updateGoods(List<Good> goods);
    void deleteGood(Good good);
    void deleteGoods(List<Good> goods);
    //bussines logic
    List<Good> findAllGoods();
    List<Good> findAllGoodsInOrder(Long orderId);

}
