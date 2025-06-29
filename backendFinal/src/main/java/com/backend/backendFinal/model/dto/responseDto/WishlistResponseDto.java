package com.backend.backendFinal.model.dto.responseDto;

import com.backend.backendFinal.model.entity.Product;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class WishlistResponseDto {
    private Integer id;
    private Product product;
    private LocalDateTime addedAt;
}
