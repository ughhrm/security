package com.backend.backendFinal.controller;

import com.backend.backendFinal.model.dto.requestDto.WishlistRequestDto;
import com.backend.backendFinal.model.dto.responseDto.WishlistResponseDto;
import com.backend.backendFinal.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistService wishlistService;

    @PostMapping("/toggle")
    public ResponseEntity<Void> toggleWishlist(@RequestBody WishlistRequestDto dto) {
        wishlistService.toggleWishlist(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WishlistResponseDto>> getAllByUser(@PathVariable Integer userId) {
        List<WishlistResponseDto> wishlistItems = wishlistService.getAllByUser(userId);
        return ResponseEntity.ok(wishlistItems);
    }
}
