package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.OrderMapper;
import com.backend.backendFinal.model.dto.OrderDto;
import com.backend.backendFinal.model.dto.responseDto.OrderResponseDto;
import com.backend.backendFinal.model.entity.Order;
import com.backend.backendFinal.repository.OrderRepository;
import com.backend.backendFinal.repository.ProductRepository;
import com.backend.backendFinal.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public OrderResponseDto getById(Integer id) {
        return orderMapper.toEntityMapResponseDto(orderRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    @Override
    public List<OrderResponseDto> getAll() {
        return orderRepository.findAll().stream().map(orderMapper::toEntityMapResponseDto).toList();
    }

    @Override
    public OrderResponseDto add(Order order) {
        return orderMapper.toEntityMapResponseDto(orderRepository.save(order));
    }

    @Override
    public OrderResponseDto update(Order order) {
        return orderMapper.toEntityMapResponseDto(orderRepository.save(order));
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }
//
//    @Override
//    public List<OrderResponseDto> getOrderByCustomerId(Integer id) {
//        return orderRepository.findByCustomerId(id).stream().map(orderMapper::toEntityMapResponseDto).toList();
//    }

}
