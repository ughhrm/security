package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.CategoryDto;
import com.backend.backendFinal.model.dto.ShopDto;
import com.backend.backendFinal.model.entity.Category;
import com.backend.backendFinal.model.entity.Shop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopMapper {
     ShopDto toShopDto(Shop shop);
}

