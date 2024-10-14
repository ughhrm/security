package com.backend.backendFinal.controller;

import com.backend.backendFinal.model.dto.CustomerDto;
import com.backend.backendFinal.model.entity.Customer;
import com.backend.backendFinal.model.entity.Order;
import com.backend.backendFinal.service.CustomerService;
import jakarta.persistence.TableGenerators;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("{id}")
    public CustomerDto getCustomerById(@PathVariable Integer id){
        return customerService.getCustomerById(id);
    }
    @PostMapping
    public CustomerDto add(@RequestBody Customer customer){
        return customerService.add(customer);

    }
    @PutMapping
    public CustomerDto update(@RequestBody  Customer customer){
        return customerService.update(customer);

    }
    @DeleteMapping
    public void delete(Integer id){
        customerService.delete(id);
    }




}
