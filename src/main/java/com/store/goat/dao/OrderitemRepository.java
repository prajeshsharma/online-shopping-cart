package com.store.goat.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderitemRepository extends CrudRepository<Orderitem, Integer> {
    List<Orderitem> findAll();
}
