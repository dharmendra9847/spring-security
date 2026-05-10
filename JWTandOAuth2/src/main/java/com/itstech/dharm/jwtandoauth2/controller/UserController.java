package com.itstech.dharm.jwtandoauth2.controller;

import com.itstech.dharm.jwtandoauth2.model.User;
import com.itstech.dharm.jwtandoauth2.service.JwtService;
import com.itstech.dharm.jwtandoauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @Autowired
    public UserController(UserService userService, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    /*  User registration   */
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    /*  Custom Login    */
//    @PostMapping("/login")
//    public String login(@RequestBody User user) {
//        Authentication authentication;
//        authentication = authenticationManager
//                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//        if (authentication.isAuthenticated()) {
//            return "success";
//        }
//
//        return "login failed";
//    }

    // Generating token
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Authentication authentication;
        authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        }

        return "login failed";
    }
}
