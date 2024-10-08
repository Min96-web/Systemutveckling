package com.example.marstravels;

public class CartEntry {
    private Product product;
    private int quantity;

    public CartEntry (Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public Product getProduct() {
        return product;
    }
    public int getQuantity () {
        return quantity;
    }
    public void increaseQuantity () {
        this.quantity++;
    }
    public void decreaseQuantity () {
        this.quantity--;
    }
}
