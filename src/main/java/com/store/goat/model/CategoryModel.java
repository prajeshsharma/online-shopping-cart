package com.store.goat.model;

import jakarta.validation.constraints.NotEmpty;

public class CategoryModel {
    @NotEmpty(message = "Please enter Category")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
