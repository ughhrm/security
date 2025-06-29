package com.backend.backendFinal.model.dto.requestDto;

import lombok.Data;

@Data
public class WishlistRequestDto {
    private Integer userId;
    private Integer productId;
}
