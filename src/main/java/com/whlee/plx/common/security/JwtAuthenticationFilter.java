package com.whlee.plx.common.security;

import com.whlee.plx.common.exception.CustomException;
import com.whlee.plx.common.exception.ErrorCode;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = jwtProvider.extractToken(request);

        if (token == null) throw new CustomException(ErrorCode.INVALID_TOKEN);
        String username = jwtProvider.getUsernameFromToken(token);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username, null));
    }


}
