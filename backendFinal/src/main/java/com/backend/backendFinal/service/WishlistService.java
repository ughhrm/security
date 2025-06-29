package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.requestDto.WishlistRequestDto;
import com.backend.backendFinal.model.dto.responseDto.WishlistResponseDto;

import java.util.List;

public interface WishlistService {
    void toggleWishlist(WishlistRequestDto dto);
    List<WishlistResponseDto> getAllByUser(Integer userId);
}
