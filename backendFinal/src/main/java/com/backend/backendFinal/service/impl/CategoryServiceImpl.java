package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.CategoryMapper;
import com.backend.backendFinal.model.dto.requestDto.CategoryRequestDto;
import com.backend.backendFinal.model.dto.responseDto.CategoryResponseDto;
import com.backend.backendFinal.model.entity.Category;
import com.backend.backendFinal.repository.CategoryRepository;
import com.backend.backendFinal.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponseDto> getAll() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toEntityMapResponseDto)
                .toList();
    }

    @Override
    public CategoryResponseDto getCategoryById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return categoryMapper.toEntityMapResponseDto(category);
    }

    @Override
    public CategoryResponseDto add(CategoryRequestDto dto) {
        Category category = categoryMapper.toRequestDtoMapEntity(dto);
        Category saved = categoryRepository.save(category);
        return categoryMapper.toEntityMapResponseDto(saved);
    }

    @Override
    public CategoryResponseDto update(Integer id, CategoryRequestDto dto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(dto.getName());
        Category updated = categoryRepository.save(category);
        return categoryMapper.toEntityMapResponseDto(updated);
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
