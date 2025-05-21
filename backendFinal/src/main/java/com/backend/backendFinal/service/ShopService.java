package com.backend.backendFinal.service;
import com.backend.backendFinal.model.dto.requestDto.ShopRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ShopResponseDto;

public interface ShopService {
    ShopResponseDto getShopById(Integer id);
    ShopResponseDto add(ShopRequestDto shopRequestDto);
    ShopResponseDto update(ShopRequestDto shopRequestDto);
    void delete(Integer id);

}