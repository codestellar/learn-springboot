package com.itdc.books.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itdc.books.entity.Product;
import com.itdc.books.entity.User;
import com.itdc.books.repository.UserRepository;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    public User createProduct(@RequestBody User user) {
        return userRepository.save(user);
    }

}
