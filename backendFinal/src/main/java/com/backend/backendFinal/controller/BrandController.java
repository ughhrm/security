package com.backend.backendFinal.controller;

import com.backend.backendFinal.model.dto.BrandDto;
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
    public BrandDto getBrandById(@PathVariable Integer id) {
        return brandService.getBrandById(id);
    }

    @PostMapping
    public BrandDto add(@RequestBody Brand brand) {
        return brandService.add(brand);
    }

    @PutMapping
    public BrandDto update(@RequestBody Brand brand) {
        return brandService.update(brand);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id){
        brandService.delete(id);
    }


}
