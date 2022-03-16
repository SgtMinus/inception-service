package ru.itmo.inceptionservice.service.token;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.itmo.inceptionservice.config.security.filters.JwtProvider;
import ru.itmo.inceptionservice.model.user.entity.User;

import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@Service
public class TokenServiceImpl implements TokenService {

    private final JwtProvider jwtProvider;

    @Override
    public String createToken(User user) {
        return jwtProvider.generateToken(user);
    }

    @Override
    public Boolean validateToken(String token, User user) {
        return jwtProvider.validateToken(token,user);
    }

    @Override
    public Map<String, String> extractClaims(String token) {
        return Map.of("email" ,jwtProvider.extractAllClaims(token).getSubject()); //???
    }
}
