package com.backend.backendFinal.model.dto.requestDto;

import com.backend.backendFinal.model.Role;

import java.util.Set;

public record CreateUserRequest (
        String name,
        String username,
        String password,
        String lastName,
        String email,
        String phone,
        String city,
        Set<Role> authorities
){
}
