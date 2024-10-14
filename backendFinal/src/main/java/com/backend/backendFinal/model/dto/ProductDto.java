package com.backend.backendFinal.model.dto;

import com.backend.backendFinal.model.entity.Brand;
import com.backend.backendFinal.model.entity.Category;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ProductDto {
    private Integer id;
    private String name;
    private Integer price;
    private BrandDto brand;
    private CategoryDto category;

}
