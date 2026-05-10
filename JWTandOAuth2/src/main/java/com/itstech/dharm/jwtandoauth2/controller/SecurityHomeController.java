package com.itstech.dharm.jwtandoauth2.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityHomeController {

    @GetMapping("home")
    public String home(HttpServletRequest request) {
        return "Welcome to the <b>ITSTech Secure Portal</b>. Your connection is authorized.";
    }

    @GetMapping("about")
    public String about(HttpServletRequest request){
        return "This service provides <b>JWT and OAuth2</b> authentication solutions for secure API access.";
    }
}
