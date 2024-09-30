package com.example.demo.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtTokenUtil {

    // Genera una chiave sicura per l'algoritmo HS256
    private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Metodo per generare il token JWT
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Token valido per 10 ore
                .signWith(secretKey)  // Firma il token con la chiave generata
                .compact();
    }

    // Estrai il nome utente dal token JWT
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Metodo generico per estrarre un singolo claim da un token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Estrai tutti i claims dal token usando la chiave segreta
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)  // Usa la chiave generata per la verifica
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Validazione del token JWT
    public Boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    // Controlla se il token è scaduto
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Estrai la data di scadenza del token
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}