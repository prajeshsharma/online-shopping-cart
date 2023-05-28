package com.store.goat.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShippingModel {
    @NotEmpty(message = "please enter address")
    private String address;
    @NotEmpty(message = "please enter city")
    private String city;
    private String state;
    @NotEmpty(message = "please enter zip code")
    @Size(min = 5, max = 5, message = "please enter a valid zip code")
    private String zipcode;
}
