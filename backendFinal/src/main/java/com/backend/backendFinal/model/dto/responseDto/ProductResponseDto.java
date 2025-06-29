package com.backend.backendFinal.model.dto.responseDto;

import lombok.Data;

import java.util.List;

@Data
public class ProductResponseDto {
    private Integer id;
    private String name;
    private Integer price;
    private String brandName;
    private String categoryName;

    private List<ProductPropertyResponseDto> properties;
}
