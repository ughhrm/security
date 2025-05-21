package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.BrandDto;
import com.backend.backendFinal.model.dto.requestDto.BrandRequestDto;
import com.backend.backendFinal.model.dto.responseDto.BrandResponseDto;
import com.backend.backendFinal.model.entity.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    Brand toRequestDtoMapEntity(BrandRequestDto brandRequestDto);

    BrandResponseDto toEntityMapResponseDto(Brand brand);
}
