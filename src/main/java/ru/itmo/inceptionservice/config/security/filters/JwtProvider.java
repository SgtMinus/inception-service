package ru.itmo.inceptionservice.config.security.filters;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import ru.itmo.inceptionservice.model.user.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtProvider {

    private final String SECRET_WORD = "PENSKOY_PENSKOY_PENSKOY";
    private final int accessTokenLifeTime = Integer.MAX_VALUE;


    public String extractUserEmailFromToken(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    public Date extractExpirationFromToken(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    public <T> T extractClaims(String token, Function<Claims, T> claimsTFunction) {
        final Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_WORD).parseClaimsJws(token).getBody();
    }

    public Boolean isTokenExpired(String token) {
        return extractExpirationFromToken(token).before(new Date());
    }

    public String generateToken(User credentials) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, credentials, accessTokenLifeTime);
    }


    private String createToken(Map<String, Object> claims, User credentials, int tokenLifeTime) {
        claims.put("role", credentials.getRole());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(credentials.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tokenLifeTime))
                .signWith(SignatureAlgorithm.HS512, SECRET_WORD)
                .compact();
    }

    public Boolean validateToken(String token, User user) {
        final String userEmail = extractUserEmailFromToken(token);
        return (userEmail.equals(user.getEmail()) && !isTokenExpired(token));
    }
}