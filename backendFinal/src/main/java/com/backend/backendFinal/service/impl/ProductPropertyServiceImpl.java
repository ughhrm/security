package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.ProductPropertyMapper;
import com.backend.backendFinal.model.dto.requestDto.ProductPropertyRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ProductPropertyResponseDto;
import com.backend.backendFinal.model.entity.ProductProperty;
import com.backend.backendFinal.repository.ProductPropertyRepository;
import com.backend.backendFinal.service.ProductPropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductPropertyServiceImpl implements ProductPropertyService {
    private final ProductPropertyMapper productPropertyMapper;
    private final ProductPropertyRepository productPropertyRepository;


    @Override
    public ProductPropertyResponseDto getById(Integer id) {
        ProductProperty productProperty = productPropertyRepository.findById(id).orElseThrow(NullPointerException::new);
        ProductPropertyResponseDto productPropertyResponseDto =productPropertyMapper.toEntityMapResponseDto(productProperty);
        return  productPropertyResponseDto;

    }

    @Override
    public ProductPropertyResponseDto add(ProductPropertyRequestDto productPropertyRequestDto) {
        ProductProperty productProperty =productPropertyMapper.toRequestDtoMapEntity(productPropertyRequestDto);
        productPropertyRepository.save(productProperty);
        ProductPropertyResponseDto productPropertyResponseDto =productPropertyMapper.toEntityMapResponseDto(productProperty);
        return  productPropertyResponseDto;

    }

    @Override
    public ProductPropertyResponseDto update(ProductPropertyRequestDto productPropertyRequestDto) {
        ProductProperty productProperty =productPropertyMapper.toRequestDtoMapEntity(productPropertyRequestDto);
        productPropertyRepository.save(productProperty);
        ProductPropertyResponseDto productPropertyResponseDto =productPropertyMapper.toEntityMapResponseDto(productProperty);
        return  productPropertyResponseDto;
    }

    @Override
    public void delete(Integer id) {
        productPropertyRepository.deleteById(id);
    }


//    @Override
//    public List<ProductPropertyDto> getProductPropertyByPropertyTypeId(Integer id) {
//        return productPropertyRepository.findByPropertyType_Id(id).stream().map(productPropertyMapper::toProductPropertyDto).toList();
//    }
}
