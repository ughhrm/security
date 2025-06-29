package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.jwt.JwtService;
import com.backend.backendFinal.model.dto.requestDto.AuthRequest;
import com.backend.backendFinal.model.dto.requestDto.CreateUserRequest;
import com.backend.backendFinal.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final UserServiceImpl userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public void saveTokenInCookie(String token, HttpServletResponse response) {
        Cookie cookie = new Cookie("jwt-token", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(30 * 24 * 60 * 60); // 30 gün
        response.addCookie(cookie);
    }
    @Override
    public String register(CreateUserRequest request) {
        userService.register(request);
        return "register oldu";
    }

    @Override
    public String login(AuthRequest request, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password()));

        if (authentication.isAuthenticated()) {
            String token = jwtService.generateToken(request.username());
            saveTokenInCookie(token, response);
            return "Token cookie-də saxlanıldı " + token;
        }

        log.info("invalid user " + request.username());
        throw new UsernameNotFoundException("invalid username: " + request.username());
    }

    @Override
    public String logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("jwt-token", null);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "Logout oldu, cookie silindi";
    }
}
