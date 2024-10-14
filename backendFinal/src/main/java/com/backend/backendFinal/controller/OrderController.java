package com.backend.backendFinal.controller;

import com.backend.backendFinal.model.dto.OrderDto;
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
    public List<OrderDto> getAll() {
        return orderService.getAll();
    }

    @GetMapping("{id}")
    public OrderDto getById(@PathVariable Integer id) {
        return orderService.getById(id);
    }

    @PostMapping
    public OrderDto add(@RequestBody Order order) {
        return orderService.add(order);
    }

    @PutMapping
    public OrderDto update(@RequestBody Order order) {
        return orderService.add(order);
    }

    @DeleteMapping
    public void delete(Integer id) {
        orderService.delete(id);
    }
    @GetMapping("/customer/{id}")
    public List<OrderDto> getOrderByCustomerId(@PathVariable Integer id){
        return orderService.getOrderByCustomerId(id);
    }
    @GetMapping("/product/{id}")
    public List<OrderDto> getOrderByProductId(@PathVariable Integer id){
        return orderService.getOrderByProductId(id);
    }

    
}
