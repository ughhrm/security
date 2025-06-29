package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.OrderDto;
import com.backend.backendFinal.model.dto.ProductPropertyDto;
import com.backend.backendFinal.model.dto.responseDto.OrderResponseDto;
import com.backend.backendFinal.model.entity.Order;

import java.util.List;

public interface OrderService {
    OrderResponseDto getById(Integer id);
    List<OrderResponseDto> getAll();
    OrderResponseDto add(Order order );
    OrderResponseDto update(Order order );
    void delete(Integer id);


}
