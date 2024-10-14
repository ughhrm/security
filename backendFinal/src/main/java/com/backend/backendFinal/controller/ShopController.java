package com.backend.backendFinal.controller;

import com.backend.backendFinal.model.dto.ShopDto;
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
    public ShopDto getShopById(@RequestParam Integer id) {
        return shopService.getShopById(id);
    }
    @PostMapping
    public ShopDto add(@RequestBody Shop shop) {
        return shopService.add(shop);
    }
    @PutMapping
    public ShopDto update(@RequestBody Shop shop){
        return shopService.update(shop);
    }
    @DeleteMapping
    public void delete(Integer id){
        shopService.delete(id);
    }
}
