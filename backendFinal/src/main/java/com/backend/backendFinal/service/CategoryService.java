package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.requestDto.CategoryRequestDto;
import com.backend.backendFinal.model.dto.responseDto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> getAll();
    CategoryResponseDto getCategoryById(Integer id);
    CategoryResponseDto add(CategoryRequestDto dto);
    CategoryResponseDto update(Integer id, CategoryRequestDto dto);
    void delete(Integer id);
}
