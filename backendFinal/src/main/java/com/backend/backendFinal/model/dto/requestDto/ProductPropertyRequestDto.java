package com.backend.backendFinal.model.dto.requestDto;

import lombok.Data;

@Data
public class ProductPropertyRequestDto {
    private Integer id;
    private String name;
    private String value;
    private Integer productId;

}
