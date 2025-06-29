package com.backend.backendFinal.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer price;


    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductProperty> properties;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,fetch =FetchType.LAZY)
    private List<Basket> basketItems;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,fetch =FetchType.LAZY)
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,fetch =FetchType.LAZY)
    private List<Wishlist> wishlists;





}
