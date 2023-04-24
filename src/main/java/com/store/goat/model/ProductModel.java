package com.store.goat.model;

import jakarta.validation.constraints.*;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public Double getTotalPrice() {
        return quantity * price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}

