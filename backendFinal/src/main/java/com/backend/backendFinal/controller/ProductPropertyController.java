package com.backend.backendFinal.controller;

import com.backend.backendFinal.model.dto.ProductPropertyDto;
import com.backend.backendFinal.model.dto.requestDto.ProductPropertyRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ProductPropertyResponseDto;
import com.backend.backendFinal.model.entity.ProductProperty;
import com.backend.backendFinal.service.ProductPropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productProperty")
@RequiredArgsConstructor
public class ProductPropertyController {
    private final ProductPropertyService productPropertyService;

    @GetMapping("{id}")
    public ProductPropertyResponseDto getById(@PathVariable Integer id){
        return productPropertyService.getById(id);
    }
    @PostMapping
    public ProductPropertyResponseDto add(@RequestBody ProductPropertyRequestDto productPropertyRequestDto){
        return productPropertyService.add(productPropertyRequestDto);
    }
    @PutMapping
    public ProductPropertyResponseDto update(@RequestBody ProductPropertyRequestDto productPropertyRequestDto){
        return productPropertyService.update(productPropertyRequestDto);
    }
    @DeleteMapping
    public void delete(Integer id){
        productPropertyService.delete(id);
    }


//
//    @GetMapping("/propertyType/{id}")
//    public List<ProductPropertyDto> getProductPropertyByPropertyType(@PathVariable Integer id){
//        return productPropertyService.getProductPropertyByPropertyTypeId(id);
//
//    }
}
