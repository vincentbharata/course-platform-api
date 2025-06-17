package com.example.course_platform.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    private static final String SECRET_KEY_STRING = "Y0uSh0uldU53L0ngErAndRand0mKey123456"; // ≥32 chars
private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes());

private static final long EXPIRATION_TIME_MS = 1000 * 60 * 60 * 10; // 10 jam

public String generateToken(String username, String role) {
    return Jwts.builder()
            .setSubject(username)
            .claim("role", role)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_MS))
            .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
            .compact();
}

public String extractUsername(String token) {
    return parseClaims(token).getSubject();
}

public String extractRole(String token) {
    return parseClaims(token).get("role", String.class);
}

public boolean validateToken(String token) {
    try {
        parseClaims(token);
        return true;
    } catch (JwtException | IllegalArgumentException e) {
        return false;
    }
}

private Claims parseClaims(String token) {
    return Jwts.parserBuilder()
            .setSigningKey(SECRET_KEY)
            .build()
            .parseClaimsJws(token)
            .getBody();
}

}