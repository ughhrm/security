package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.CategoryDto;
import com.backend.backendFinal.model.dto.requestDto.CategoryRequestDto;
import com.backend.backendFinal.model.dto.responseDto.CategoryResponseDto;
import com.backend.backendFinal.model.entity.Category;
import com.backend.backendFinal.model.entity.Order;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto getById(Integer id);
    CategoryResponseDto add(Category category);
    CategoryResponseDto update(Category category);
    void delete(Integer id);

}
