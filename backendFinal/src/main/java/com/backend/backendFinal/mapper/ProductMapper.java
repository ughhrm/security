package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.requestDto.ProductRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ProductResponseDto;
import com.backend.backendFinal.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductPropertyMapper.class})
public interface ProductMapper {


    Product toRequestDtoMapEntity(ProductRequestDto productRequestDto);

    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "category.name", target = "categoryName")
    ProductResponseDto toEntityMapResponseDto(Product product);

}

