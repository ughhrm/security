package com.backend.backendFinal.model.dto.responseDto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class BasketResponseDto {

    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer quantity;
}
