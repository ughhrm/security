package com.backend.backendFinal.service;


import com.backend.backendFinal.model.dto.requestDto.ProductRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto create(ProductRequestDto dto);

    ProductResponseDto update(Integer id, ProductRequestDto dto);

    void delete(Integer id);

    ProductResponseDto getById(Integer id);

    List<ProductResponseDto> getAll();

}
