package com.store.goat.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrdersRepository extends CrudRepository<Orders, Integer> { }
