package com.backend.backendFinal.model.dto.requestDto;

import com.backend.backendFinal.model.dto.BrandDto;
import lombok.Data;

import java.util.List;

@Data
public class ProductRequestDto {
    private String name;
    private Integer price;
    private Integer brandId;
    private Integer categoryId;
    private List<ProductPropertyRequestDto> properties;



}
