package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.requestDto.ProductRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ProductResponseDto;
import com.backend.backendFinal.model.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toRequestDtoMapEntity(ProductRequestDto productRequestDto);
    ProductResponseDto toEntityMapResponseDto(Product product);
}
