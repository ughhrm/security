package com.backend.backendFinal.mapper;
import com.backend.backendFinal.model.dto.requestDto.OrderRequestDto;
import com.backend.backendFinal.model.dto.responseDto.OrderResponseDto;
import com.backend.backendFinal.model.entity.Order;
import org.mapstruct.Mapper;




@Mapper(componentModel = "spring", uses = {OrderItemMapper.class})
public interface OrderMapper {

    Order toRequestDtoMapEntity(OrderRequestDto dto);

    OrderResponseDto toEntityMapResponseDto(Order order);

}
