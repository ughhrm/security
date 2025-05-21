package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.ShopMapper;
import com.backend.backendFinal.model.dto.requestDto.ShopRequestDto;
import com.backend.backendFinal.model.dto.responseDto.ShopResponseDto;
import com.backend.backendFinal.model.entity.Shop;
import com.backend.backendFinal.repository.ShopRepository;
import com.backend.backendFinal.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final ShopMapper shopMapper;
    public ShopResponseDto getShopById(Integer id){
       Shop shop = shopRepository.findById(id).orElseThrow(NullPointerException::new);
       ShopResponseDto shopResponseDto =shopMapper.toEntityMapResponseDto(shop);
       return shopResponseDto;
    }


    @Override
    public ShopResponseDto add(ShopRequestDto shopRequestDto) {
        Shop shop = shopMapper.toRequestDtoMapEntity(shopRequestDto);
        shopRepository.save(shop);
        ShopResponseDto shopResponseDto =shopMapper.toEntityMapResponseDto(shop);
        return shopResponseDto;
    }

    @Override
    public ShopResponseDto update(ShopRequestDto shopRequestDto) {
        Shop shop =shopMapper.toRequestDtoMapEntity(shopRequestDto);
        shopRepository.save(shop);
        ShopResponseDto shopResponseDto =shopMapper.toEntityMapResponseDto(shop);
        return shopResponseDto;

    }

    @Override
    public void delete(Integer id) {
       shopRepository.deleteById(id);
    }


}
