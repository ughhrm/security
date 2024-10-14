package com.backend.backendFinal.service;
import com.backend.backendFinal.model.dto.ShopDto;
import com.backend.backendFinal.model.entity.Shop;

public interface ShopService {
    ShopDto getShopById(Integer id);
    ShopDto add(Shop shop);
    ShopDto update(Shop shop);
    void delete(Integer id);

}