package com.backend.backendFinal.model.dto.requestDto;

import lombok.Data;

@Data
public class ShopRequestDto {
    private Integer id;
    private String address;
    private String shortNumber;
    private String email;
}
