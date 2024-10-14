package com.backend.backendFinal.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerDto {

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String city;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


}
