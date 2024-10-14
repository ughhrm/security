package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.CategoryMapper;
import com.backend.backendFinal.model.dto.CategoryDto;
import com.backend.backendFinal.model.entity.Category;
import com.backend.backendFinal.model.entity.PropertyType;
import com.backend.backendFinal.repository.CategoryRepository;
import com.backend.backendFinal.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    @Override
    public CategoryDto getById(Integer id) {
        return categoryMapper.toCategoryDto(categoryRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    @Override
    public CategoryDto add(Category category) {
        return categoryMapper.toCategoryDto(categoryRepository.save(category));
    }

    @Override
    public CategoryDto update(Category category) {
        return categoryMapper.toCategoryDto(categoryRepository.save(category));
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }


}
