package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.ProductDto;
import com.backend.backendFinal.model.dto.ProductPropertyDto;
import com.backend.backendFinal.model.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toProductDto(Product product);
}
