package com.backend.backendFinal.model.dto.requestDto;

import lombok.Data;

import java.util.Set;

@Data
public class UserRequestDto {

    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String city;

    private Set<String> authorities;
}
