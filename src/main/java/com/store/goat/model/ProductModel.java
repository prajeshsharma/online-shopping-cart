package com.store.goat.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductModel {
    private Integer productId;
    @NotEmpty(message = "Please enter product name")
    private String name;
    @NotEmpty(message = "Please enter product description")
    private String description;
    @NotNull(message = "Please enter product price")
    private Double price;
    @NotNull(message = "Please enter product quantity")
    private Integer quantity;
    @NotEmpty(message = "Please enter product's image URL")
    private String imageUrl;
    @NotNull(message = "Please enter product's category ID")
    private Integer categoryId;

    public Double getTotal() {
        return null;
    }
}

