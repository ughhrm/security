package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.OrderMapper;
import com.backend.backendFinal.model.dto.OrderDto;
import com.backend.backendFinal.model.entity.Order;
import com.backend.backendFinal.model.entity.Product;
import com.backend.backendFinal.repository.OrderRepository;
import com.backend.backendFinal.repository.ProductRepository;
import com.backend.backendFinal.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public OrderDto getById(Integer id) {
        return orderMapper.toOrderDto(orderRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    @Override
    public List<OrderDto> getAll() {
        return orderRepository.findAll().stream().map(orderMapper::toOrderDto).toList();
    }

    @Override
    public OrderDto add(Order order) {
        return orderMapper.toOrderDto(orderRepository.save(order));
    }

    @Override
    public OrderDto update(Order order) {
        return orderMapper.toOrderDto(orderRepository.save(order));
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderDto> getOrderByCustomerId(Integer id) {
        return orderRepository.findByCustomerId(id).stream().map(orderMapper::toOrderDto).toList();
    }

    @Override
    public List<OrderDto> getOrderByProductId(Integer id) {
        return orderRepository.findByProductId(id).stream().map(orderMapper::toOrderDto).toList();

    }
}
