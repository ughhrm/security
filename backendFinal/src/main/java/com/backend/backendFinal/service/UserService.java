package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.requestDto.CreateUserRequest;
import com.backend.backendFinal.model.dto.requestDto.UserRequestDto;
import com.backend.backendFinal.model.dto.responseDto.UserResponseDto;
import com.backend.backendFinal.model.security.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserResponseDto register(CreateUserRequest request);


}
