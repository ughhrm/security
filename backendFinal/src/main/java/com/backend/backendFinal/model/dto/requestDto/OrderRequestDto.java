package com.backend.backendFinal.model.dto.requestDto;

import com.backend.backendFinal.enums.DeliveryMethod;
import com.backend.backendFinal.enums.PaymentMethod;
import com.backend.backendFinal.enums.PaymentStatus;
//import com.backend.backendFinal.model.entity.Customer;
import com.backend.backendFinal.model.entity.Product;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class OrderRequestDto {
    private Integer userId;
    private List<OrderItemRequestDto> orderItems;
}
