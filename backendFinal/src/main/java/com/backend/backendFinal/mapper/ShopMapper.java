package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.CategoryDto;
import com.backend.backendFinal.model.dto.ShopDto;
import com.backend.backendFinal.model.dto.requestDto.OrderRequestDto;
import com.backend.backendFinal.model.dto.requestDto.ShopRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ShopResponseDto;
import com.backend.backendFinal.model.entity.Category;
import com.backend.backendFinal.model.entity.Shop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopMapper {


     Shop toRequestDtoMapEntity(ShopRequestDto shopRequestDto);
     ShopResponseDto toEntityMapResponseDto(Shop shop);
}

