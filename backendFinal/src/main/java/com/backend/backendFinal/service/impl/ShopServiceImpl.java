package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.ShopMapper;
import com.backend.backendFinal.model.dto.ShopDto;
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
    public ShopDto getShopById(Integer id){
        return shopMapper.toShopDto(shopRepository.findById(id).orElseThrow(NullPointerException::new));

    }

    @Override
    public ShopDto add(Shop shop) {
        return shopMapper.toShopDto(shopRepository.save(shop));
    }

    @Override
    public ShopDto update(Shop shop) {
        return shopMapper.toShopDto(shopRepository.save(shop));
    }

    @Override
    public void delete(Integer id) {
       shopRepository.deleteById(id);
    }


}
