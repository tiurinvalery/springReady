package com.yopselmopsel.service.repo;

import com.yopselmopsel.service.model.Good;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodRepository extends CrudRepository<Good,Long>{
    Good findGoodByName(String name);
    Good findGoodById(Long id);
    List<Good> findGoodsByNameLike(String name);
    List<Good> findAll();
}
