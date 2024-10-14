package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.ProductPropertyDto;
import com.backend.backendFinal.model.entity.Product;
import com.backend.backendFinal.model.entity.ProductProperty;
import lombok.Data;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductPropertyMapper {
    ProductPropertyDto toProductPropertyDto(ProductProperty productProperty);
}
