package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.BasketMapper;
import com.backend.backendFinal.model.dto.requestDto.BasketRequestDto;
import com.backend.backendFinal.model.dto.responseDto.BasketResponseDto;
import com.backend.backendFinal.model.entity.Basket;
import com.backend.backendFinal.model.entity.Product;
import com.backend.backendFinal.model.security.User;
import com.backend.backendFinal.repository.BasketRepository;
import com.backend.backendFinal.repository.ProductRepository;
import com.backend.backendFinal.repository.UserRepository;
import com.backend.backendFinal.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final BasketMapper basketMapper;

    @Override
    public List<BasketResponseDto> getAll() {
        return basketRepository.findAll()
                .stream()
                .map(basketMapper::toEntityMapResponseDto)
                .toList();
    }

    @Override
    public BasketResponseDto getById(Integer id) {
        Basket basket = basketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Basket item not found"));
        return basketMapper.toEntityMapResponseDto(basket);
    }

    @Override
    public BasketResponseDto create(BasketRequestDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Basket basket = basketMapper.toRequestDtoMapEntity(dto);
        basket.setUser(user);
        basket.setProduct(product);

        Basket saved = basketRepository.save(basket);
        return basketMapper.toEntityMapResponseDto(saved);
    }

    @Override
    public BasketResponseDto update(Integer id, BasketRequestDto dto) {
        Basket existing = basketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Basket item not found"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existing.setQuantity(dto.getQuantity());
        existing.setUser(user);
        existing.setProduct(product);

        Basket updated = basketRepository.save(existing);
        return basketMapper.toEntityMapResponseDto(updated);
    }

    @Override
    public void delete(Integer id) {
        basketRepository.deleteById(id);
    }
}
