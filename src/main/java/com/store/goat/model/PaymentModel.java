package com.store.goat.model;

import jakarta.validation.constraints.*;

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

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
