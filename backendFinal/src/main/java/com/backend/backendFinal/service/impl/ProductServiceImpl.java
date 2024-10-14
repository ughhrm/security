package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.ProductMapper;
import com.backend.backendFinal.model.dto.ProductDto;
import com.backend.backendFinal.model.dto.ProductPropertyDto;
import com.backend.backendFinal.model.entity.Product;
import com.backend.backendFinal.model.entity.ProductProperty;
import com.backend.backendFinal.repository.ProductPropertyRepository;
import com.backend.backendFinal.repository.ProductRepository;
import com.backend.backendFinal.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;



    @Override
    public ProductDto getById(Integer id) {
        return productMapper.toProductDto(productRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    @Override
    public ProductDto add(Product product) {
        return productMapper.toProductDto(productRepository.save(product));
    }

    @Override
    public ProductDto update(Product product) {
        return  productMapper.toProductDto(productRepository.save(product));
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);

    }

    @Override
    public List<ProductDto> getProductByBrandId(Integer id) {
        return productRepository.findByBrand_Id(id).stream().map(productMapper::toProductDto).toList();
    }

    @Override
    public List<ProductDto> getProductByCategoryId(Integer id) {
        return productRepository.findByCategory_Id(id).stream().map(productMapper::toProductDto).toList();
    }

}
