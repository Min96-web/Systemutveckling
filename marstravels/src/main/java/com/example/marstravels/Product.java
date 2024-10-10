package com.example.marstravels;

import java.util.List;

public class Product {
    private String productName;
    private int productPrice;

    public Product (String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName () {
        return this.productName;
    }
    public int getProductPrice () {
        return this.productPrice;
    }
    public static Product valueOf (String productName, String path) {
        List<String> list;
        FileHandler reader = new FileHandler();
        list = reader.read( path );
        Product tempProduct = new Product("", 1);
        int number = 0;
        for (String temp : list) {
            String[] array = temp.split(":");
            if (productName.equals(array[0].toUpperCase()))
                tempProduct = new Product(array[0], number = Integer.parseInt(array[1]));
        }
        return tempProduct;
    }
    public String toString () {
        return productName + ";" + productPrice;
    }
}
