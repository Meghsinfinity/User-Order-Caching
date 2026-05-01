package com.example.user;

import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserOrderCachingApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;
    public static void main(String[] args) {
        SpringApplication.run(UserOrderCachingApplication.class, args);
    }
    @Override
    public void run(String... args) {
        var user1 = userService.getUser(1);
        System.out.println(user1.getName());
        user1.getOrders().forEach(o -> System.out.println(o.getProductName()));
        var user2 = userService.getUser(user1.getId());
        System.out.println(user2.getName());
        user2.getOrders().forEach(o -> System.out.println(o.getProductName()));
    }
}