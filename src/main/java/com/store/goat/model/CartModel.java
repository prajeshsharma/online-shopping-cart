package com.store.goat.model;

import java.util.List;

public class CartModel {
    private List<ProductModel> items;
    private Double subtotal;
    private Double tax;
    private Double total;
    public List<ProductModel> getItems() {
        return items;
    }

    public void setItems(List<ProductModel> items) {
        this.items = items;
    }

    public Double getSubtotal() {
        subtotal = 0.0;
        for (ProductModel item : items)
            subtotal += item.getTotalPrice();
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTax() {
        tax = 0.0;
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotal() {
        total = getTax() + getSubtotal();
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void add(ProductModel productModel) {
        items.add(productModel);
    }
}
