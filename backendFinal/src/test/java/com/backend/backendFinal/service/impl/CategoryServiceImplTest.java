package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.CategoryMapper;
import com.backend.backendFinal.model.dto.CategoryDto;
import com.backend.backendFinal.model.entity.Category;
import com.backend.backendFinal.repository.CategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {
    @InjectMocks
    CategoryServiceImpl categoryService;
    @Mock
    CategoryRepository categoryRepository;
    @Mock
    CategoryMapper categoryMapper;

    private Category category;
    private CategoryDto categoryDto;

    @BeforeEach
    void setUp() {
        category = new Category();
        category.setId(1);
        category.setName("Air conditioners");
        categoryDto = new CategoryDto();
        categoryDto.setId(1);
        categoryDto.setName("Air conditioners");
    }

    @AfterEach
    void tearDown() {
        category = null;
        categoryDto = null;

    }

    @Test
    void getCategoryById() {
        when(categoryRepository.findById(anyInt())).thenReturn(Optional.of(category));
        when(categoryMapper.toCategoryDto(category)).thenReturn(categoryDto);
        //Act
        CategoryDto categoryDto1 = categoryService.getById(1);
        //Assert
        assertEquals(categoryDto, categoryDto1);

        verify(categoryRepository, times(1)).findById(1);
        verify(categoryMapper, times(1)).toCategoryDto(category);


    }

    @Test
    void add() {
        when(categoryRepository.save(any())).thenReturn(category);
        when(categoryMapper.toCategoryDto(category)).thenReturn(categoryDto);

        CategoryDto categoryDto1 = categoryService.add(category);

        assertEquals(categoryDto, categoryDto1);

        verify(categoryRepository, times(1)).save(category);
        verify(categoryMapper, times(1)).toCategoryDto(category);
    }

    @Test
    void update() {
        when(categoryRepository.save(any())).thenReturn(category);
        when(categoryMapper.toCategoryDto(category)).thenReturn(categoryDto);

        CategoryDto categoryDto1 = categoryService.update(category);

        assertEquals(categoryDto, categoryDto1);

        verify(categoryRepository, times(1)).save(category);
        verify(categoryMapper, times(1)).toCategoryDto(category);
    }

    @Test
    void delete() {
        Integer id = 1;
        categoryService.delete(id);
        verify(categoryRepository, times(1)).deleteById(id);
    }
}