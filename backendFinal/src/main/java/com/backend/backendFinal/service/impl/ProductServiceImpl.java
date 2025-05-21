package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.ProductMapper;
import com.backend.backendFinal.mapper.ProductPropertyMapper;
import com.backend.backendFinal.model.dto.ProductDto;
import com.backend.backendFinal.model.dto.requestDto.ProductRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ProductResponseDto;
import com.backend.backendFinal.model.entity.Product;
import com.backend.backendFinal.model.entity.ProductProperty;
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
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final ProductPropertyRepository productPropertyRepository;
    private  final ProductPropertyMapper productPropertyMapper;

    @Override
    public ProductResponseDto getById(Integer id) {
        return productMapper.toEntityMapResponseDto(productRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    @Override
    public ProductResponseDto add(ProductRequestDto productRequestDto) {
        // DTO-dan Entity-ə çevirmə (brand və s. üçün mapper istifadə oluna bilər)
        Product product = productMapper.toRequestDtoMapEntity(productRequestDto);

        
        // ProductProperty-ləri ID-lərə əsasən tapıb siyahıya yığırıq
        List<ProductProperty> productProperties = new ArrayList<>();
        if (productRequestDto.getProductPropertyId() != null) {
            for (Integer propertyId : productRequestDto.getProductPropertyId()) {
                ProductProperty property = productPropertyRepository.findById(propertyId)
                        .orElseThrow(() -> new RuntimeException("ProductProperty tapılmadı: ID = " + propertyId));
                productProperties.add(property);
            }
        }

        // Entity-yə productProperties-i təyin edirik
        product.setProductProperties(productProperties);

        // Product-u bazaya yazırıq
        productRepository.save(product);

        // Entity-ni Response DTO-ya çeviririk və qaytarırıq
        return productMapper.toEntityMapResponseDto(product);
    }


    @Override
    public ProductResponseDto update(ProductRequestDto productRequestDto) {
        Product product =productMapper.toRequestDtoMapEntity(productRequestDto);
        productRepository.save(product);
        ProductResponseDto productResponseDto =productMapper.toEntityMapResponseDto(product);
        return productResponseDto;    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);

    }

    @Override
    public List<ProductResponseDto> getProductByBrandId(Integer id) {
        return productRepository.findByBrand_Id(id).stream().map(productMapper::toEntityMapResponseDto).toList();
    }

//    @Override
//    public List<ProductPropertyDto> getProductPropertyByProduct(Integer id) {
//        Product product = productRepository.getById(id);
//        List<ProductPropertyDto>  productPropertyDto = productPropertyRepository
//                .findByProduct(product).stream()
//                .map(productProperty -> productPropertyMapper.toProductPropertyDto(productProperty))
//                .collect(Collectors.toList());
//        return productPropertyDto;
//    }


}
