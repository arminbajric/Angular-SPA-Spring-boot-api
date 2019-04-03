package com.example.reminder.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtUtillity  {
    private final String key="jwt";

    public String generateJwt(String email)
    {
        return Jwts.builder().setSubject(email).setIssuedAt(new Date())
            .signWith(SignatureAlgorithm.HS256, key).compact();
    }
}
