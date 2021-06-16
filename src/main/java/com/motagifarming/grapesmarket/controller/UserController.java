package com.motagifarming.grapesmarket.controller;

import com.motagifarming.grapesmarket.enitity.User;
import com.motagifarming.grapesmarket.model.Product;
import com.motagifarming.grapesmarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/graphmarket/v1/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "users")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping(path = "users/{id}")
    public User getUser(@PathVariable("id") Integer userId){
        return userRepository.findById(userId).get();
    }

    @GetMapping(path = "users")
    public Iterable<User> getAllUser(){
        return userRepository.findAll();
    }
}
