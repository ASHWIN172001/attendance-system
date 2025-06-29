package com.attendance.attendance_system.util;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "YourVeryLongSecretKeyAtLeast32CharactersIamironman"; // 🔐 Use strong key in production
    private final long EXPIRATION_TIME = 1000 * 60 * 10 ; // 10 minutes

    // 🔑 Generate JWT token
    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)// payload: sub = username
                .claim("role",role) // claiming role
                .setIssuedAt(new Date()) // issuing date
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // expiration date
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    //  Validate token
    public boolean validateToken(String token, String username) {
        String extractedUsername = extractUsername(token);
        return (username.equals(extractedUsername) && !isTokenExpired(token));
    }

    //  Extract username (subject)
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    //  Check token expiration
    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    public String extractRole(String token) {
        return extractClaims(token).get("role", String.class);
    }

    //  Extract all claims
    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
