package com.backend.backendFinal.filter;

import com.backend.backendFinal.service.AuthService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.Authentication;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final List<AuthService> authServices;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Optional<Authentication> authOptional=Optional.empty();
        for (AuthService authService: authServices){
            authOptional = authOptional.or(()->authService.getAuthentication(request));
        }
        authOptional.ifPresent(auth-> {
            SecurityContextHolder.getContext().setAuthentication(auth);
        });
        filterChain.doFilter(request, response);
    }
}
