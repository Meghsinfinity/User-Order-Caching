package com.example.user.entity;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private String productName;

    public Order() {}

    public Order(String productName) {
        this.productName = productName;
    }

    public int getOrderId() { return orderId; }
    public String getProductName() { return productName; }
}