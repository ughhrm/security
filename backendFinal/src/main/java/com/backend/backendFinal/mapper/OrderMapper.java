package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.OrderDto;
import com.backend.backendFinal.model.dto.requestDto.OrderRequestDto;
import com.backend.backendFinal.model.dto.responseDto.OrderResponseDto;
import com.backend.backendFinal.model.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toRequestDtoMapEntity(OrderRequestDto orderRequestDto);
    OrderResponseDto toEntityMapResponseDto(Order order);
}
