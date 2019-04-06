package com.example.reminder.security;

import com.example.reminder.services.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtUtillity  {
   private final UserService userService;

    public JwtUtillity(UserService userService) {
        this.userService = userService;
    }

    public String generateJwt(String email)
    {
        return Jwts.builder().setSubject(email).setIssuedAt(new Date())
            .signWith(SignatureAlgorithm.HS256, userService.getKey().getKey()).compact();
    }
    public String extractEmail(String token) throws JwtException {

        Claims claims = Jwts.parser()
                .setSigningKey(userService.getKey().getKey())
                .parseClaimsJws(token)
                .getBody();
        System.out.print(claims.getSubject());
        System.out.print(userService.getKey().getKey());
      return  claims.getSubject();

    }
}
