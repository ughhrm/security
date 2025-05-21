package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.CategoryMapper;
import com.backend.backendFinal.model.dto.CategoryDto;
import com.backend.backendFinal.model.dto.requestDto.CategoryRequestDto;
import com.backend.backendFinal.model.dto.responseDto.CategoryResponseDto;
import com.backend.backendFinal.model.entity.Category;
import com.backend.backendFinal.repository.CategoryRepository;
import com.backend.backendFinal.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    @Override
    public CategoryResponseDto getById(Integer id) {
        return categoryMapper.toEntityMapResponseDto(categoryRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    @Override
    public CategoryResponseDto add(Category category) {
        return categoryMapper.toEntityMapResponseDto(categoryRepository.save(category));
    }

    @Override
    public CategoryResponseDto update(Category category) {
        return categoryMapper.toEntityMapResponseDto(categoryRepository.save(category));
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }


}
