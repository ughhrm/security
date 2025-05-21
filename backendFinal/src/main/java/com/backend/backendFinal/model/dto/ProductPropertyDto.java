package com.backend.backendFinal.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductPropertyDto {

    private Integer id;
    private String propertyValue;
    private Integer productId;

}
