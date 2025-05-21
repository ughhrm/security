package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.ProductDto;
import com.backend.backendFinal.model.dto.ProductPropertyDto;
import com.backend.backendFinal.model.dto.requestDto.ProductRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ProductResponseDto;
import com.backend.backendFinal.model.entity.Product;
import jakarta.persistence.Id;

import java.util.List;

public interface ProductService {
    ProductResponseDto getById(Integer id);
    ProductResponseDto add(ProductRequestDto productRequestDto);
    ProductResponseDto update(ProductRequestDto productRequestDto);
    void delete(Integer id);

    List<ProductResponseDto> getProductByBrandId(Integer id);
//   List<ProductPropertyDto> getProductPropertyByProduct(Integer id);


}
