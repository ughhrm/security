package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.ProductPropertyDto;
import com.backend.backendFinal.model.entity.ProductProperty;

import java.util.List;

public interface ProductPropertyService {
    ProductPropertyDto getById(Integer id);

    ProductPropertyDto add(ProductProperty productProperty);

    ProductPropertyDto update(ProductProperty productProperty);

    void delete(Integer id);
    List<ProductPropertyDto> getProductPropertyByProductId(Integer id);
    List<ProductPropertyDto> getProductPropertyByPropertyTypeId(Integer id);


}
