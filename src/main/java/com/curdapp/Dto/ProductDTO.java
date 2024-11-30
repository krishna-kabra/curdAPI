package com.curdapp.Dto;

import com.curdapp.entity.Product;

import lombok.Data;

@Data
public class ProductDTO {
    private int pid;
    private String product_name;
    private double price;
    private int quantity;

    // Constructor
    public ProductDTO(Product product) {
        this.pid = product.getPid();
        this.product_name = product.getProduct_name();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }

    // Getters and Setters
}
