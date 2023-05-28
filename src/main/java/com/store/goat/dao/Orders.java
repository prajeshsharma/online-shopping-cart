package com.store.goat.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity

public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer order_id;
    private Integer user_id;
    @Column(name = "order_date", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date order_date;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean is_shipped;
    private String order_status;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private Double subtotal;
    private Double total;
}
