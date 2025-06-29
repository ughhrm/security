package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.WishlistMapper;
import com.backend.backendFinal.model.dto.requestDto.WishlistRequestDto;
import com.backend.backendFinal.model.dto.responseDto.WishlistResponseDto;
import com.backend.backendFinal.model.entity.Product;
import com.backend.backendFinal.model.entity.Wishlist;
import com.backend.backendFinal.model.security.User;
import com.backend.backendFinal.repository.ProductRepository;
import com.backend.backendFinal.repository.UserRepository;
import com.backend.backendFinal.repository.WishlistRepository;
import com.backend.backendFinal.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final WishlistRepository wishlistRepository;
    private final WishlistMapper wishlistMapper;

    @Override
    public void toggleWishlist(WishlistRequestDto dto) {
        Integer userId = dto.getUserId();
        Integer productId = dto.getProductId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Optional<Wishlist> existingWishlist = wishlistRepository.findByUserIdAndProductId(userId, productId);

        if (existingWishlist.isPresent()) {
            wishlistRepository.delete(existingWishlist.get());
        } else {
            Wishlist newWishlist = new Wishlist();
            newWishlist.setUser(user);
            newWishlist.setProduct(product);
            newWishlist.setAddedAt(LocalDateTime.now());

            wishlistRepository.save(newWishlist);
        }
    }

    @Override
    public List<WishlistResponseDto> getAllByUser(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }
        List<Wishlist> wishlists = wishlistRepository.findAllByUserId(userId);

        return wishlists.stream()
                .map(wishlistMapper::toEntityMapResponseDto)
                .toList();
    }
}
