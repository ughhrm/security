package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.CustomerMapper;
import com.backend.backendFinal.model.dto.CustomerDto;
import com.backend.backendFinal.model.entity.Customer;
import com.backend.backendFinal.model.entity.Order;
import com.backend.backendFinal.repository.CustomerRepository;
import com.backend.backendFinal.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;


    public CustomerDto getCustomerById(Integer id) {
        return customerMapper.toCustomerDto(customerRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    @Override
    public CustomerDto add(Customer customer) {
        return customerMapper.toCustomerDto(customerRepository.save(customer));
    }

    @Override
    public CustomerDto update(Customer customer) {
        return customerMapper.toCustomerDto(customerRepository.save(customer));
    }


    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);

    }


}
