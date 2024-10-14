package com.backend.backendFinal.controller;

import com.backend.backendFinal.model.dto.CategoryDto;
import com.backend.backendFinal.model.entity.Category;
import com.backend.backendFinal.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("{id}")
    public CategoryDto getById(@PathVariable Integer id) {
        return categoryService.getById(id);
    }

    @PostMapping
    public CategoryDto add(@RequestBody Category category) {
        return categoryService.add(category);
    }

    @PutMapping
    public CategoryDto update(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        categoryService.delete(id);
    }

}
