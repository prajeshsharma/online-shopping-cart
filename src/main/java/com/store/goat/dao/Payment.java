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
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer payment_id;
    private Integer order_id;
    private String card_name;
    private String card_number;
    private Integer month;
    private Integer year;
    private String cvv;
}
