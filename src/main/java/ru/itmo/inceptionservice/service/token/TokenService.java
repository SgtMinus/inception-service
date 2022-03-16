package ru.itmo.inceptionservice.service.token;

import ru.itmo.inceptionservice.model.user.entity.User;

import java.util.Map;

public interface TokenService {
    String createToken(User user);
    Boolean validateToken(String token, User user);
    Map<String,String> extractClaims(String token);
}
