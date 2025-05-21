package com.backend.backendFinal.model.dto;


import lombok.Data;

@Data
public class ProductDto {
    private Integer id;
    private String name;
    private Integer price;
    private BrandDto brand;


}
