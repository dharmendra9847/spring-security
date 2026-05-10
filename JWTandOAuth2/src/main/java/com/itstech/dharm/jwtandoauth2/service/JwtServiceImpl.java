package com.itstech.dharm.jwtandoauth2.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtServiceImpl implements JwtService {

    // Hardcoded Key
    private static final String SECRET = "TmV3U2VjcmV0S2V5Rm9ySldUU29uZ2luZ21hc2sgZmF2b3I=";

    private final String secretKey;

    public JwtServiceImpl() {
        secretKey = generateSecretKey();
    }

    // Dynamic Key Generation Using Method @(I AM USING THIS NOT HARDCODED)
    public String generateSecretKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secKey = keyGen.generateKey();
            System.out.println("Secret Key : " + secKey.toString());
            return Base64.getEncoder().encodeToString(secKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating secret key", e);
        }
    }

    // Generate JWT Token
    @Override
    public String generateToken(String username) {

        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new  Date(System.currentTimeMillis()))
                .setExpiration(new  Date(System.currentTimeMillis() + 3600 * 1000))
                .signWith(getKey(),  SignatureAlgorithm.HS256)
                .compact();
    }

    // Convert Secret String into Key
    private Key getKey() {
       byte[] keyByte = Decoders.BASE64.decode(secretKey);
       return Keys.hmacShaKeyFor(keyByte);
    }
}
