package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.OrderDto;
import com.backend.backendFinal.model.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toOrderDto(Order order);
}
