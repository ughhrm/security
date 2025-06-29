package com.backend.backendFinal.controller;

import com.backend.backendFinal.model.dto.requestDto.ProductPropertyRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ProductPropertyResponseDto;
import com.backend.backendFinal.service.ProductPropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-properties")
@RequiredArgsConstructor
public class ProductPropertyController {

    private final ProductPropertyService productPropertyService;

    @PostMapping
    public ResponseEntity<ProductPropertyResponseDto> create(@RequestBody ProductPropertyRequestDto dto) {
        return ResponseEntity.ok(productPropertyService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductPropertyResponseDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(productPropertyService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductPropertyResponseDto>> getAll() {
        return ResponseEntity.ok(productPropertyService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductPropertyResponseDto> update(@PathVariable Integer id,
                                                             @RequestBody ProductPropertyRequestDto dto) {
        return ResponseEntity.ok(productPropertyService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productPropertyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
