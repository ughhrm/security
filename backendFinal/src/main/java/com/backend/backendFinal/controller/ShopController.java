package com.backend.backendFinal.controller;

import com.backend.backendFinal.model.dto.ShopDto;
import com.backend.backendFinal.model.dto.requestDto.ShopRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ShopResponseDto;
import com.backend.backendFinal.model.entity.Shop;
import com.backend.backendFinal.service.ShopService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @GetMapping
    public ShopResponseDto getShopById(@RequestParam Integer id) {
        return shopService.getShopById(id);
    }
    @PostMapping
    public ShopResponseDto add(@RequestBody ShopRequestDto shopRequestDto) {
        return shopService.add(shopRequestDto);
    }
    @PutMapping
    public ShopResponseDto update(@RequestBody ShopRequestDto shopRequestDto){
        return shopService.update(shopRequestDto);
    }
    @DeleteMapping
    public void delete(Integer id){
        shopService.delete(id);
    }
}
