package br.com.erp.seguranca.domain.entity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;


public class Token {
    private static final String SECRET = "CHAVESECRETAFORTEAQUI11111111111111111111111";

    public String generateToken(String user) {
        Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        long expirationMillis = 120 * 60 * 1000; // 120 minutos
        Date now = new Date();
        Date expiration = new Date(now.getTime() + expirationMillis);

        String token = Jwts.builder()
                .setSubject(user)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();

        return token;
    }

    public static String validate(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getSubject(); // username
        } catch (Exception e) {
            return null; // token inválido ou expirado
        }
    }

}
