package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.CustomerDto;
import com.backend.backendFinal.model.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface CustomerMapper {
    CustomerDto toCustomerDto(Customer customer);
}
