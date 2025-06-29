package com.backend.backendFinal.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ProductProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Column(name = "property_value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
