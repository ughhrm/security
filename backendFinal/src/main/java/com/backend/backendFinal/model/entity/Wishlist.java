package com.backend.backendFinal.model.entity;

import com.backend.backendFinal.model.security.User;
import jakarta.persistence.*;
import lombok.Data;
import org.apache.commons.lang3.builder.EqualsExclude;

import java.time.LocalDateTime;

@Entity
@Data
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private LocalDateTime addedAt;
}
