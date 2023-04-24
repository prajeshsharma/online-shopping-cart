package com.store.goat.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orderitem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer orderitem_id;
    private Integer order_id;
    private Integer product_id;
    private Integer quantity;

    public Integer getOrderitem_id() {
        return orderitem_id;
    }

    public void setOrderitem_id(Integer orderitem_id) {
        this.orderitem_id = orderitem_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
