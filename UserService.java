package com.example.user.service;

import com.example.user.entity.Order;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private Map<Integer, User> cache = new HashMap<>();
    public User getUser(int id) {
        if (cache.containsKey(id)) {
            System.out.println("Fetching from Cache...");
            return cache.get(id);
        }
        System.out.println("Fetching from Database...");
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("Mobile"));
        orders.add(new Order("Laptop"));
        User user = new User("Meghana", orders);
        user = userRepository.save(user);
        cache.put(user.getId(), user);
        return user;
    }
}