package com.backend.backendFinal.controller;

import com.backend.backendFinal.model.dto.requestDto.BrandRequestDto;
import com.backend.backendFinal.model.dto.responseDto.BrandResponseDto;
import com.backend.backendFinal.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<List<BrandResponseDto>> getAll() {
        return ResponseEntity.ok(brandService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandResponseDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(brandService.getBrandById(id));
    }

    @PostMapping
    public ResponseEntity<BrandResponseDto> create(@RequestBody BrandRequestDto dto) {
        return ResponseEntity.ok(brandService.add(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandResponseDto> update(@PathVariable Integer id, @RequestBody BrandRequestDto dto) {
        return ResponseEntity.ok(brandService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        brandService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
