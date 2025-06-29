package com.backend.backendFinal.model.dto.responseDto;

import com.backend.backendFinal.enums.DeliveryMethod;
import com.backend.backendFinal.enums.PaymentMethod;
import com.backend.backendFinal.enums.PaymentStatus;
import com.backend.backendFinal.model.entity.Product;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class OrderResponseDto {
    private Integer id;
    private Integer userId;
    private Timestamp createTime;
    private List<OrderItemResponseDto> orderItems;
}
