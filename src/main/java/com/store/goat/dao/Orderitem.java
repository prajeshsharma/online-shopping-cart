package com.store.goat.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Orderitem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer orderitem_id;
    private Integer order_id;
    private Integer product_id;
    private Integer quantity;
}
