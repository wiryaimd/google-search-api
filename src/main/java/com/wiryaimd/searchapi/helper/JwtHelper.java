package com.wiryaimd.searchapi.helper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtHelper {

    private Logger logger = LoggerFactory.getLogger(JwtHelper.class);

    @Value("${jwt.secret}")
    private String secretKey;

    public Map<String, Object> validateToken(String token) {
        try{
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (JwtException e){
            e.printStackTrace();
            return null;
        }
    }

    public String generateToken(String subject, Map<String, Object> claims, long current){
        return Jwts.builder()
                .setSubject(subject)
                .addClaims(claims)
                .setExpiration(new Date(current))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

}
