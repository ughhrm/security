package com.backend.backendFinal.model.dto.responseDto;

import com.backend.backendFinal.model.dto.BrandDto;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponseDto {
    private Integer id;
    private String name;
    private Integer price;
    private BrandDto brand;
    private List<Integer> productPropertyId;


}
