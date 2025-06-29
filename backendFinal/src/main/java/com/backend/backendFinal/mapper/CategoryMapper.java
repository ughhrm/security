package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.CategoryDto;
import com.backend.backendFinal.model.dto.requestDto.CategoryRequestDto;
import com.backend.backendFinal.model.dto.responseDto.CategoryResponseDto;
import com.backend.backendFinal.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    Category toRequestDtoMapEntity(CategoryRequestDto categoryRequestDto);
    CategoryResponseDto toEntityMapResponseDto(Category category);


}
