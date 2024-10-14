package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.CustomerMapper;
import com.backend.backendFinal.model.dto.CustomerDto;
import com.backend.backendFinal.model.entity.Customer;
import com.backend.backendFinal.repository.CustomerRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {
    @InjectMocks
    CustomerServiceImpl customerService;

    @Mock
    CustomerRepository customerRepository;
    @Mock
    CustomerMapper customerMapper;

    private Customer customer;
    private CustomerDto customerDto;


    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Ugur");
        customer.setLastName("Huseynov");
        customer.setEmail("Ugur123123");
        customer.setPhone("050343434");
        customer.setCity("Baku");

        customerDto = new CustomerDto();
        customerDto.setFirstName("Ugur");
        customerDto.setLastName("Huseynov");
        customerDto.setEmail("Ugur123123");
        customerDto.setPhone("050343434");
        customerDto.setCity("Baku");


    }

    @AfterEach
    void tearDown() {
        customer= null;
        customerDto= null;
    }

    @Test
    void getCustomerById() {
        when(customerRepository.findById(anyInt())).thenReturn(Optional.of(customer));
        when(customerMapper.toCustomerDto(customer)).thenReturn(customerDto);

        CustomerDto customerDto1 =customerService.getCustomerById(1);

        assertEquals(customerDto, customerDto1);

        verify(customerRepository,times(1)).findById(1);
        verify(customerMapper,times(1)).toCustomerDto(customer);

    }

    @Test
    void add() {
        when(customerRepository.save(any())).thenReturn(customer);
        when(customerMapper.toCustomerDto(customer)).thenReturn(customerDto);

        CustomerDto customerDto1 =customerService.add(customer);

        assertEquals(customerDto,customerDto1);

        verify(customerRepository,times(1)).save(customer);
        verify(customerMapper,times(1)).toCustomerDto(customer);

    }

    @Test
    void update() {
        when(customerRepository.save(any())).thenReturn(customer);
        when(customerMapper.toCustomerDto(customer)).thenReturn(customerDto);

        CustomerDto customerDto1 = customerService.update(customer);

        assertEquals(customerDto, customerDto1);
        verify(customerRepository,times(1)).save(customer);
        verify(customerMapper,times(1)).toCustomerDto(customer);


    }

    @Test
    void delete() {
        Integer id = 1;
        customerService.delete(id);
        verify(customerRepository,times(1)).deleteById(id);
    }
}