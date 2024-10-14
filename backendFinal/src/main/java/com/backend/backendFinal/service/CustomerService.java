package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.CustomerDto;
import com.backend.backendFinal.model.entity.Customer;
import com.backend.backendFinal.model.entity.Order;


public interface CustomerService {
    CustomerDto getCustomerById(Integer id);
    CustomerDto add(Customer customer);
    CustomerDto update(Customer customer);
    void delete(Integer id);

}
