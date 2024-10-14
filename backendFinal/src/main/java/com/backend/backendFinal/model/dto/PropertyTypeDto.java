package com.backend.backendFinal.model.dto;

import com.backend.backendFinal.model.entity.Category;
import lombok.Data;

@Data
public class PropertyTypeDto {
    private Integer id;
    private String name;
    private Category category;
}
