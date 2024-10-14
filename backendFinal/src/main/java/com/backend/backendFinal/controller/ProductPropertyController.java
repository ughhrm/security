package com.backend.backendFinal.controller;

import com.backend.backendFinal.model.dto.ProductPropertyDto;
import com.backend.backendFinal.model.dto.PropertyTypeDto;
import com.backend.backendFinal.model.entity.ProductProperty;
import com.backend.backendFinal.model.entity.PropertyType;
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
    public ProductPropertyDto getById(@PathVariable Integer id){
        return productPropertyService.getById(id);
    }
    @PostMapping
    public ProductPropertyDto add(@RequestBody ProductProperty productProperty){
        return productPropertyService.add(productProperty);
    }
    @PutMapping
    public ProductPropertyDto update(@RequestBody ProductProperty productProperty){
        return productPropertyService.update(productProperty);
    }
    @DeleteMapping
    public void delete(Integer id){
        productPropertyService.delete(id);
    }
    @GetMapping("/product/{id}")
    public List<ProductPropertyDto> getProductPropertyByProduct(@PathVariable Integer id){
        return productPropertyService.getProductPropertyByProductId(id);

    }

    @GetMapping("/propertyType/{id}")
    public List<ProductPropertyDto> getProductPropertyByPropertyType(@PathVariable Integer id){
        return productPropertyService.getProductPropertyByPropertyTypeId(id);

    }
}
