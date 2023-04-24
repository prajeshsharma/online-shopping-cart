package com.store.goat.model;


import jakarta.validation.constraints.*;

public class UserModel {
    @NotEmpty(message = "Please enter name")
    String name;
    @NotEmpty
    @Email(message = "Please enter valid email")
    String email;
    @NotEmpty(message = "Please enter password")
    String password;
    @NotEmpty(message = "Please re-enter password")
    String password1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

}
