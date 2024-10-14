package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.CategoryDto;
import com.backend.backendFinal.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toCategoryDto(Category category);

}
