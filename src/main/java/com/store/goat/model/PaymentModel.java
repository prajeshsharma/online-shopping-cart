package com.store.goat.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentModel {
    @NotEmpty(message = "Please enter name on card")
    private String cardName;
    @NotEmpty(message = "Please enter number on card")
    private String cardNumber;
    private Integer month;
    @NotNull(message = "Please enter expiration year")
    private Integer year;
    @NotEmpty(message = "please enter CVV number")
    @Size(min = 3, max = 3, message = "Please enter valid CVV number")
    private String cvv;

    public PaymentModel() {
        year = null;
    }
}
