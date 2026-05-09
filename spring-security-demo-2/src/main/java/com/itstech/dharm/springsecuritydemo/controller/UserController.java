package com.itstech.dharm.springsecuritydemo.controller;

import com.itstech.dharm.springsecuritydemo.model.User;
import com.itstech.dharm.springsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public User register(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }
}
