package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.requestDto.BasketRequestDto;
import com.backend.backendFinal.model.dto.responseDto.BasketResponseDto;
import com.backend.backendFinal.model.entity.Basket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BasketMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "productId", target = "product.id")
    Basket toRequestDtoMapEntity(BasketRequestDto dto);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "product.id", target = "productId")
    BasketResponseDto toEntityMapResponseDto(Basket entity);
}
