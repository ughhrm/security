package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.CategoryDto;
import com.backend.backendFinal.model.entity.Category;
import com.backend.backendFinal.model.entity.Order;
import com.backend.backendFinal.model.entity.PropertyType;

import java.util.List;

public interface CategoryService {
    CategoryDto getById(Integer id);
    CategoryDto add(Category category);
    CategoryDto update(Category category);
    void delete(Integer id);

}
