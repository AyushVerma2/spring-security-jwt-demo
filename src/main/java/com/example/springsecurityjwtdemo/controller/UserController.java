package com.example.springsecurityjwtdemo.controller;

import com.example.springsecurityjwtdemo.model.MyUser;
import com.example.springsecurityjwtdemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepo userRepo;

    @GetMapping("/all")
    public List<MyUser> getUser(){
        return  userRepo.findAll();

    }
    @GetMapping("/")
    public String welcome(){
        return  "welcome to spring security";

    }
}
