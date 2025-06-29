package com.backend.backendFinal.filter;

import com.backend.backendFinal.jwt.JwtService;
import com.backend.backendFinal.service.AuthService;
import com.backend.backendFinal.service.UserService;
import com.backend.backendFinal.service.impl.UserServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.Authentication;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserServiceImpl userDetailsServiceImpl;

    public JwtAuthFilter( JwtService jwtService, UserServiceImpl userDetailsServiceImpl) {
        this.jwtService = jwtService;

        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String userName =null;
        if (authHeader !=null && authHeader.startsWith("Bearer ")){
            token= authHeader.substring(7);
            userName = jwtService.extractUser(token);

        }


        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails user =userDetailsServiceImpl.loadUserByUsername(userName);
            if (jwtService.validateToken(token, user)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
           authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
           SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
