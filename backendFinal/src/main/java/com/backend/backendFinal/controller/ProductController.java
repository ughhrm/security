package com.backend.backendFinal.controller;
import com.backend.backendFinal.model.dto.BrandDto;
import com.backend.backendFinal.model.dto.ProductDto;
import com.backend.backendFinal.model.dto.ProductPropertyDto;
import com.backend.backendFinal.model.dto.requestDto.ProductRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ProductResponseDto;
import com.backend.backendFinal.model.entity.Product;
import com.backend.backendFinal.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ProductResponseDto getBtId(@PathVariable Integer id){
        return productService.getById(id);
    }
    @PostMapping
    public ProductResponseDto add(@RequestBody ProductRequestDto productRequestDto){
        return productService.add(productRequestDto);
    }
    @PutMapping
    public ProductResponseDto update(@RequestBody ProductRequestDto productRequestDto){
        return productService.update(productRequestDto);
    }
    @DeleteMapping
    public void delete(@RequestParam Integer id){
        productService.delete(id);
    }
    @GetMapping("/brand/{id}")
    public List<ProductResponseDto> getProductByBrandId(@PathVariable Integer id){
        return productService.getProductByBrandId(id);
    }
//    @GetMapping("/brand/{id}")
//    public  ProductDto<List<ProductPropertyDto>> getProductPropertyByProduct(@PathVariable Integer id){
//        return ProductDto.ok(productService.getProductPropertyByProduct(id));
//    }





}
