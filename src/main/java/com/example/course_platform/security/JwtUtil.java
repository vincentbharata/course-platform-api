package com.example.course_platform.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    // Gantilah ini dengan kunci Base64 yang kuat dari env atau properties di real app
    private static final String SECRET_KEY_STRING = "Y0uSh0uldU53L0ngErAndRand0mKey123456"; // minimal 32 chars

    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes());

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 jam
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }
}
