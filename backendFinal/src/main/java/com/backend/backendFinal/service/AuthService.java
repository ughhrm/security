package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.requestDto.AuthRequest;
import com.backend.backendFinal.model.dto.requestDto.CreateUserRequest;
import com.backend.backendFinal.model.dto.requestDto.UserRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;

import java.util.Optional;

public interface AuthService {
    String register(CreateUserRequest request);
    String login(AuthRequest request, HttpServletResponse response);
    String logout(HttpServletResponse response);
}
