package com.itstech.dharm.jwtandoauth2.service;

public interface JwtService {

    // Generating token
    String generateToken(String username);
}
