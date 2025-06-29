package com.backend.backendFinal.model.dto.requestDto;

import lombok.Data;

@Data
public class OrderItemRequestDto {
    private Integer productId;
    private Integer quantity;
    private Integer price;
    private String deliveryMethod; // enum string
    private String paymentMethod;  // enum string
    private String paymentStatus;
}
