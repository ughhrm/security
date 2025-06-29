package com.backend.backendFinal.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;

@Service
@Slf4j
public class JwtService {
    @Value("${issue.key}")
    private String issueKey;


    @PostConstruct
    public Key secretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(issueKey);
        return Keys.hmacShaKeyFor(keyBytes);

    }

    public String generateToken(String userName) {
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims , userName);



    }
    public Boolean validateToken(String token, UserDetails userDetails){
        String username = extractUser(token);
        Date expirationDate = extractExpiration(token);
        return userDetails.getUsername().equals(username) && !expirationDate.before(new Date());


    }

    public String extractUser(String token){
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(secretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();


    }
    private Date extractExpiration(String token){
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(secretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getExpiration();


    }

    private String  createToken(Map<String, Object> claims, String userName){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 30))
                .signWith(secretKey(), SignatureAlgorithm.HS256)
                .compact();
    }

}
