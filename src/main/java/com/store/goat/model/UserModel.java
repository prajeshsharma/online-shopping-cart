package com.store.goat.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
}
