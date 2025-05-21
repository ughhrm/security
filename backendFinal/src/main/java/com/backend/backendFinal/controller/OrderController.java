package com.backend.backendFinal.controller;

import com.backend.backendFinal.model.dto.OrderDto;
import com.backend.backendFinal.model.dto.responseDto.OrderResponseDto;
import com.backend.backendFinal.model.entity.Order;
import com.backend.backendFinal.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderResponseDto> getAll() {
        return orderService.getAll();
    }

    @GetMapping("{id}")
    public OrderResponseDto getById(@PathVariable Integer id) {
        return orderService.getById(id);
    }

    @PostMapping
    public OrderResponseDto add(@RequestBody Order order) {
        return orderService.add(order);
    }

    @PutMapping
    public OrderResponseDto update(@RequestBody Order order) {
        return orderService.add(order);
    }

    @DeleteMapping
    public void delete(Integer id) {
        orderService.delete(id);
    }
//    @GetMapping("/customer/{id}")
//    public List<OrderResponseDto> getOrderByCustomerId(@PathVariable Integer id){
//        return orderService.getOrderByCustomerId(id);
//    }
    @GetMapping("/product/{id}")
    public List<OrderResponseDto> getOrderByProductId(@PathVariable Integer id){
        return orderService.getOrderByProductId(id);
    }

    
}
