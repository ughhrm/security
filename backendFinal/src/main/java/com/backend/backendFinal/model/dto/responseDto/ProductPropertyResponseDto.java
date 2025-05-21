package com.backend.backendFinal.model.dto.responseDto;

import com.backend.backendFinal.model.dto.BrandDto;
import lombok.Data;

@Data
public class ProductPropertyResponseDto {
    private Integer id;
    private String propertyValue;
    private Integer productId;


}
