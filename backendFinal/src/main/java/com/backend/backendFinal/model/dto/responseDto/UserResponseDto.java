package com.backend.backendFinal.model.dto.responseDto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class UserResponseDto {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String city;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Set<String> authorities;
}