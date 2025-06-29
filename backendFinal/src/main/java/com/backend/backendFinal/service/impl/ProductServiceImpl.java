package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.ProductMapper;
import com.backend.backendFinal.mapper.ProductPropertyMapper;
import com.backend.backendFinal.model.dto.ProductDto;
import com.backend.backendFinal.model.dto.requestDto.ProductPropertyRequestDto;
import com.backend.backendFinal.model.dto.requestDto.ProductRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ProductResponseDto;
import com.backend.backendFinal.model.entity.Brand;
import com.backend.backendFinal.model.entity.Category;
import com.backend.backendFinal.model.entity.Product;
import com.backend.backendFinal.model.entity.ProductProperty;
import com.backend.backendFinal.repository.BrandRepository;
import com.backend.backendFinal.repository.CategoryRepository;
import com.backend.backendFinal.repository.ProductPropertyRepository;
import com.backend.backendFinal.repository.ProductRepository;
import com.backend.backendFinal.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final ProductPropertyRepository productPropertyRepository;  // BU İLƏ ƏLAVƏ ET
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDto create(ProductRequestDto dto) {
        Product product = productMapper.toRequestDtoMapEntity(dto);

        Brand brand = brandRepository.findById(dto.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        product.setBrand(brand);
        product.setCategory(category);

        if (dto.getProperties() != null) {
            List<ProductProperty> properties = dto.getProperties().stream().map(pDto -> {
                ProductProperty property = new ProductProperty();
                property.setProduct(product);
                property.setName(pDto.getName());
                property.setValue(pDto.getValue());
                return property;
            }).toList();
            product.setProperties(properties);
        }

        Product savedProduct = productRepository.save(product);

        return productMapper.toEntityMapResponseDto(savedProduct);
    }


    @Override
    public ProductResponseDto update(Integer id, ProductRequestDto dto) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Brand brand = brandRepository.findById(dto.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        existing.setName(dto.getName());
        existing.setPrice(dto.getPrice());
        existing.setBrand(brand);
        existing.setCategory(category);

        for (ProductPropertyRequestDto pDto : dto.getProperties()) {
            for (ProductProperty p : existing.getProperties()) {
                if (p.getId().equals(pDto.getId())) {
                    p.setName(pDto.getName());
                    p.setValue(pDto.getValue());
                    break; // tapdıq, artıq davam etməyə ehtiyac yoxdur
                }
            }
        }


        Product updated = productRepository.save(existing);
        return productMapper.toEntityMapResponseDto(updated);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductResponseDto getById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.toEntityMapResponseDto(product);
    }

    @Override
    public List<ProductResponseDto> getAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toEntityMapResponseDto)
                .toList();
    }
}
