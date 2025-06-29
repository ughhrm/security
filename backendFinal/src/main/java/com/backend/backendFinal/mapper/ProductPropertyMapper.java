package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.ProductPropertyDto;
import com.backend.backendFinal.model.dto.requestDto.ProductPropertyRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ProductPropertyResponseDto;
import com.backend.backendFinal.model.entity.Product;
import com.backend.backendFinal.model.entity.ProductProperty;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductPropertyMapper {

    ProductProperty toRequestDtoMapEntity(ProductPropertyRequestDto dto);

    @Mapping(source = "product.id", target = "productId")
    ProductPropertyResponseDto toEntityMapResponseDto(ProductProperty entity);

    List<ProductPropertyResponseDto> toEntityMapResponseDto(List<ProductProperty> entities);
}