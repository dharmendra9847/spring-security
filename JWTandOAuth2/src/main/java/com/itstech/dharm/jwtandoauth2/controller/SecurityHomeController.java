package com.itstech.dharm.jwtandoauth2.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityHomeController {

    @GetMapping("home")
    public String home(HttpServletRequest request) {
        return "Hello World! + \nYour sessionID is: " + request.getSession().getId();
    }

    @GetMapping("about")
    public String about(HttpServletRequest request){
        return "Hello, this about for me!, What do you want to do? \nYour sessionID is: " + request.getSession().getId();
    }
}
