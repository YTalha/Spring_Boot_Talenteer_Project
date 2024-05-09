package com.project.talenteer.core.service;

import org.springframework.stereotype.Service;

import com.project.talenteer.core.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class JwtService {

    private static final String SECRET_KEY = "3e27faab4a9cbac3f2e4f598d07f3c3cda245d1e4e0ae28f96a7c1b021f389de";

    public String generateToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getEmail());
        claims.put("id", user.getId());
        claims.put("userName", user.getUserName());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

}
