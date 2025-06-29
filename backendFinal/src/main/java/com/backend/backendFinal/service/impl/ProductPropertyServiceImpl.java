package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.ProductPropertyMapper;
import com.backend.backendFinal.model.dto.requestDto.ProductPropertyRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ProductPropertyResponseDto;
import com.backend.backendFinal.model.entity.Product;
import com.backend.backendFinal.model.entity.ProductProperty;
import com.backend.backendFinal.repository.ProductPropertyRepository;
import com.backend.backendFinal.repository.ProductRepository;
import com.backend.backendFinal.service.ProductPropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductPropertyServiceImpl implements ProductPropertyService {

    private final ProductPropertyRepository productPropertyRepository;
    private final ProductRepository productRepository;
    private final ProductPropertyMapper productPropertyMapper;

    @Override
    public ProductPropertyResponseDto create(ProductPropertyRequestDto dto) {
        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ProductProperty property = productPropertyMapper.toRequestDtoMapEntity(dto);
        property.setProduct(product);

        ProductProperty saved = productPropertyRepository.save(property);
        return productPropertyMapper.toEntityMapResponseDto(saved);
    }

    @Override
    public ProductPropertyResponseDto update(Integer id, ProductPropertyRequestDto dto) {
        ProductProperty property = productPropertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        property.setProduct(product);
        property.setName(dto.getName());
        property.setValue(dto.getValue());

        ProductProperty updated = productPropertyRepository.save(property);
        return productPropertyMapper.toEntityMapResponseDto(updated);
    }

    @Override
    public void delete(Integer id) {
        productPropertyRepository.deleteById(id);
    }

    @Override
    public ProductPropertyResponseDto getById(Integer id) {
        ProductProperty property = productPropertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));
        return productPropertyMapper.toEntityMapResponseDto(property);
    }

    @Override
    public List<ProductPropertyResponseDto> getAll() {
        return productPropertyRepository.findAll()
                .stream()
                .map(productPropertyMapper::toEntityMapResponseDto)
                .toList();
    }
}
