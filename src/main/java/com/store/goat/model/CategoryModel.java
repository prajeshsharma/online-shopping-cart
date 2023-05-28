package com.store.goat.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryModel {
    @NotEmpty(message = "Please enter Category")
    private String name;
}
