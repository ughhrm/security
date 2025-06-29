package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.requestDto.OrderItemRequestDto;
import com.backend.backendFinal.model.dto.responseDto.OrderItemResponseDto;
import com.backend.backendFinal.model.entity.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {


    OrderItem toRequestDtoMapEntity(OrderItemRequestDto orderItemRequestDto);

    OrderItemResponseDto toEntityMapResponseDto(OrderItem orderItem);

}
