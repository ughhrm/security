package com.backend.backendFinal.model.dto.responseDto;

import java.security.Timestamp;

public class OrderItemResponseDto {
    private Integer id;
    private Integer productId;
    private String productName;
    private Integer quantity;
    private Integer price;
    private String deliveryMethod;
    private String paymentMethod;
    private String paymentStatus;
    private Timestamp createTime;
}
