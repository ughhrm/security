package com.backend.backendFinal.controller;

import com.backend.backendFinal.model.dto.requestDto.AuthRequest;
import com.backend.backendFinal.model.dto.requestDto.CreateUserRequest;
import com.backend.backendFinal.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody CreateUserRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request, HttpServletResponse response) {
        return authService.login(request, response);
    }

    @PostMapping("/logout")
    public String logout(HttpServletResponse response) {
        return authService.logout(response);
    }
}
