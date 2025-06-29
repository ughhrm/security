package com.backend.backendFinal.repository;

import com.backend.backendFinal.model.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    Optional<Wishlist> findByUserIdAndProductId(Integer userId, Integer productId);
    List<Wishlist> findAllByUserId(Integer userId);

}