package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.ProductDto;
import com.backend.backendFinal.model.dto.ProductPropertyDto;
import com.backend.backendFinal.model.entity.Product;
import jakarta.persistence.Id;

import java.util.List;

public interface ProductService {
    ProductDto getById(Integer id);
    ProductDto add(Product product);
    ProductDto update(Product product);
    void delete(Integer id);

    List<ProductDto> getProductByBrandId(Integer id);
    List<ProductDto> getProductByCategoryId(Integer id);


}
