package ru.itmo.inceptionservice.config.security.filters;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.itmo.inceptionservice.model.user.repository.UserRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Log4j2
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final String TOKEN_PREFIX = "Bearer ";
    private final String TOKEN_HEADER = "Authorization";

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest httpServletRequest, @NonNull HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = extractToken(httpServletRequest);
        try {
            if(!token.isEmpty()) {
                var email = jwtProvider.extractUserEmailFromToken(token);
                var user = userRepository.findByEmail(email).orElseThrow();
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(user,
                                null,
                                Collections.singletonList(new SimpleGrantedAuthority(user.getRole().toString())));
                authenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                httpServletRequest.setAttribute("email", email);
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            }
        } catch (Exception e){
            log.info("token not found or invalid!");
            httpServletResponse.setStatus(403);
        }
    }

    private String extractToken(HttpServletRequest request){
        return request
                .getHeader(TOKEN_HEADER)
                .replace(TOKEN_PREFIX,"");
    }
}