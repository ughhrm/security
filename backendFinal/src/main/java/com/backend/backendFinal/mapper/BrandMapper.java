package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.BrandDto;
import com.backend.backendFinal.model.entity.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandDto toBrandDto(Brand brand);
}
