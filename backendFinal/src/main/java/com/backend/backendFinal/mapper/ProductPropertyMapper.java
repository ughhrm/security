package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.ProductPropertyDto;
import com.backend.backendFinal.model.dto.requestDto.ProductPropertyRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ProductPropertyResponseDto;
import com.backend.backendFinal.model.entity.Product;
import com.backend.backendFinal.model.entity.ProductProperty;
import lombok.Data;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductPropertyMapper {

    ProductProperty toRequestDtoMapEntity(ProductPropertyRequestDto productPropertyRequestDto);
    ProductPropertyResponseDto toEntityMapResponseDto(ProductProperty productProperty);
}
