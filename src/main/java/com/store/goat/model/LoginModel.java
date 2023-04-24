package com.store.goat.model;


import jakarta.validation.constraints.*;

public class LoginModel {
    @NotEmpty
    @Email(message = "Please enter valid email")
    String email;
    @NotEmpty(message = "Please enter password")
    String password;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
