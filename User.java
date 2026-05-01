package com.example.user.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Order> orders;
    public User() {}
    public User(String name, List<Order> orders) {
        this.name = name;
        this.orders = orders;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public List<Order> getOrders() { return orders; }
}