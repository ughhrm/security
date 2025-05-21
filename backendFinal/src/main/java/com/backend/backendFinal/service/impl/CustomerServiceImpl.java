//package com.backend.backendFinal.service.impl;
//
//import com.backend.backendFinal.mapper.CustomerMapper;
//import com.backend.backendFinal.model.dto.CustomerDto;
//import com.backend.backendFinal.model.dto.responseDto.CustomerResponseDto;
//import com.backend.backendFinal.model.entity.Customer;
//import com.backend.backendFinal.model.entity.Order;
//import com.backend.backendFinal.repository.CustomerRepository;
//import com.backend.backendFinal.service.CustomerService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@Service
//public class CustomerServiceImpl implements CustomerService {
//    private final CustomerMapper customerMapper;
//    private final CustomerRepository customerRepository;
//
//
//    public CustomerResponseDto getCustomerById(Integer id) {
//        return customerMapper.toEntityMapResponseDto(customerRepository.findById(id).orElseThrow(NullPointerException::new));
//    }
//
//    @Override
//    public CustomerResponseDto add(Customer customer) {
//        return customerMapper.toEntityMapResponseDto(customerRepository.save(customer));
//    }
//
//    @Override
//    public CustomerResponseDto update(Customer customer) {
//        return customerMapper.toEntityMapResponseDto(customerRepository.save(customer));
//    }
//
//
//    @Override
//    public void delete(Integer id) {
//        customerRepository.deleteById(id);
//
//    }
//
//
//}
