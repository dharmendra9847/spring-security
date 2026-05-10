package com.itstech.dharm.jwtandoauth2.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    // Generating token
    String generateToken(String username);

    String extractUserName(String token);

    boolean validateToke(String token, UserDetails userDetails);
}
