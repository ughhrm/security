package com.backend.backendFinal.controller;
import com.backend.backendFinal.model.dto.BrandDto;
import com.backend.backendFinal.model.dto.ProductDto;
import com.backend.backendFinal.model.dto.ProductPropertyDto;
import com.backend.backendFinal.model.entity.Product;
import com.backend.backendFinal.model.entity.PropertyType;
import com.backend.backendFinal.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("{id}")
    public ProductDto getBtId(@PathVariable Integer id){
        return productService.getById(id);
    }
    @PostMapping
    public ProductDto add(@RequestBody Product product){
        return productService.add(product);
    }
    @PutMapping
    public ProductDto update(@RequestBody Product product){
        return productService.update(product);
    }
    @DeleteMapping
    public void delete(@RequestParam Integer id){
        productService.delete(id);
    }
    @GetMapping("/brand/{id}")
    public List<ProductDto> getProductByBrandId(@PathVariable Integer id){
        return productService.getProductByBrandId(id);
    }
    @GetMapping("/category/{id}")
    public List<ProductDto> getProductByCategoryId(@PathVariable Integer id){
        return productService.getProductByCategoryId(id);
    }



}
