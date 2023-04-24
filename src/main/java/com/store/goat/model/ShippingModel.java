package com.store.goat.model;

import jakarta.validation.constraints.*;

public class ShippingModel {
    @NotEmpty(message = "please enter address")
    private String address;
    @NotEmpty(message = "please enter city")
    private String city;
    private String state;
    @NotEmpty(message = "please enter zip code")
    @Size(min = 5, max = 5, message = "please enter a valid zip code")
    private String zipcode;
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
}
