package com.backend.backendFinal.model.dto.requestDto;

import com.backend.backendFinal.model.entity.Category;
import lombok.Data;

@Data
public class PropertyTypeRequestDto {
    private Integer id;
    private String name;
    private Category category;
}
