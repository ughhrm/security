package com.backend.backendFinal.controller;

import com.backend.backendFinal.model.dto.BrandDto;
import com.backend.backendFinal.model.dto.responseDto.BrandResponseDto;
import com.backend.backendFinal.model.entity.Brand;
import com.backend.backendFinal.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @GetMapping("{id}")
    public BrandResponseDto  getBrandById(@PathVariable Integer id) {
        return brandService.getBrandById(id);
    }

    @PostMapping
    public BrandResponseDto add(@RequestBody Brand brand) {
        return brandService.add(brand);
    }

    @PutMapping
    public BrandResponseDto  update(@RequestBody Brand brand) {
        return brandService.update(brand);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id){
        brandService.delete(id);
    }


}
