package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.OrderDto;
import com.backend.backendFinal.model.dto.ProductPropertyDto;
import com.backend.backendFinal.model.entity.Order;

import java.util.List;

public interface OrderService {
    OrderDto getById(Integer id);
    List<OrderDto> getAll();
    OrderDto add(Order order );
    OrderDto update(Order order );
    void delete(Integer id);
    List<OrderDto> getOrderByCustomerId(Integer id);
    List<OrderDto> getOrderByProductId(Integer id);


}
