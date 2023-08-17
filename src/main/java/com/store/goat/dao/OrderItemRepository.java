package com.store.goat.dao;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderItemRepository extends CrudRepository<Orderitem, Integer> {
    @NotNull List<Orderitem> findAll();
}
