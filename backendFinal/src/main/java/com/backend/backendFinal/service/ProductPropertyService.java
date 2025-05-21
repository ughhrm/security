package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.requestDto.ProductPropertyRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ProductPropertyResponseDto;

public interface ProductPropertyService {
    ProductPropertyResponseDto getById(Integer id);

    ProductPropertyResponseDto add(ProductPropertyRequestDto productPropertyRequestDto);

    ProductPropertyResponseDto update(ProductPropertyRequestDto productPropertyRequestDto);

    void delete(Integer id);
//    List<ProductPropertyDto> getProductPropertyByPropertyTypeId(Integer id);


}
