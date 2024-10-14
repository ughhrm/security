package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.ProductPropertyMapper;
import com.backend.backendFinal.model.dto.ProductPropertyDto;
import com.backend.backendFinal.model.entity.ProductProperty;
import com.backend.backendFinal.repository.ProductPropertyRepository;
import com.backend.backendFinal.service.ProductPropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductPropertyServiceImpl implements ProductPropertyService {
    private final ProductPropertyMapper productPropertyMapper;
    private final ProductPropertyRepository productPropertyRepository;


    @Override
    public ProductPropertyDto getById(Integer id) {
        return productPropertyMapper.toProductPropertyDto(productPropertyRepository.findById(id)
                .orElseThrow(NullPointerException::new));
    }

    @Override
    public ProductPropertyDto add(ProductProperty productProperty) {
        return productPropertyMapper.toProductPropertyDto(productPropertyRepository.save(productProperty));
    }

    @Override
    public ProductPropertyDto update(ProductProperty productProperty) {
        return productPropertyMapper.toProductPropertyDto(productPropertyRepository.save(productProperty));
    }

    @Override
    public void delete(Integer id) {
        productPropertyRepository.deleteById(id);
    }

    @Override
    public List<ProductPropertyDto> getProductPropertyByProductId(Integer id) {
        return productPropertyRepository.findByProduct_Id(id).stream().map(productPropertyMapper::toProductPropertyDto).toList();
    }

    @Override
    public List<ProductPropertyDto> getProductPropertyByPropertyTypeId(Integer id) {
        return productPropertyRepository.findByPropertyType_Id(id).stream().map(productPropertyMapper::toProductPropertyDto).toList();
    }
}
