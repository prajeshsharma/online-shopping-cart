package com.store.goat.dao;

import jakarta.persistence.*;

import java.util.Date;
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
    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public boolean getIs_shipped() {
        return is_shipped;
    }

    public void setIs_shipped(boolean is_shipped) {
        this.is_shipped = is_shipped;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
