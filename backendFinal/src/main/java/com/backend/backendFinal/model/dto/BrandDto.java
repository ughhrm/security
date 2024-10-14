package com.backend.backendFinal.model.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class BrandDto {
    private Integer id;
    private String name;

}
