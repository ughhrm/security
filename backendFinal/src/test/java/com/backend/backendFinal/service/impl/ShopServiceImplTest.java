package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.BackendFinalApplication;
import com.backend.backendFinal.mapper.ShopMapper;
import com.backend.backendFinal.model.dto.ShopDto;
import com.backend.backendFinal.model.entity.Shop;
import com.backend.backendFinal.repository.ShopRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ShopServiceImplTest {
    @InjectMocks
    ShopServiceImpl shopService;
    @Mock
    ShopRepository shopRepository;
    @Mock
    ShopMapper shopMapper;

    private Shop shop;
    private ShopDto shopDto;

    @BeforeEach
    void setUp() {
        shop = new Shop();
        shop.setId(1);
        shop.setAddress("Baku");

        shopDto= new ShopDto();
        shopDto.setId(1);
        shopDto.setAddress("Baku");


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getShopById() {
    }

    @Test
    void add() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}