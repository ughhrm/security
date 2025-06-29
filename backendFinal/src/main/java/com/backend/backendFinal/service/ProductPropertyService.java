package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.requestDto.ProductPropertyRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ProductPropertyResponseDto;

import java.util.List;

public interface ProductPropertyService {

    ProductPropertyResponseDto create(ProductPropertyRequestDto dto);

    ProductPropertyResponseDto update(Integer id, ProductPropertyRequestDto dto);

    void delete(Integer id);

    ProductPropertyResponseDto getById(Integer id);

    List<ProductPropertyResponseDto> getAll();
}
