package com.whlee.plx.common.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtProvider {

    @Value("${jwt-key}")
    private SecretKey jwtKey;

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .verifyWith(jwtKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public String generatedToken(UserDetails user) {
        return Jwts.builder()
                .subject(user.getUsername())
                .signWith(jwtKey)
                .claim("authorities", user.getAuthorities())
                .compact();
    }

    public String extractToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Bearer ")) {
            return authorization.substring(7);
        }
        return null;
    }
}
