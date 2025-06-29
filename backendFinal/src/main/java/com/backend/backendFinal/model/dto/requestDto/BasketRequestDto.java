package com.backend.backendFinal.model.dto.requestDto;

import lombok.Data;

@Data
public class BasketRequestDto {
    private Integer userId;
    private Integer productId;
    private Integer quantity;

}
