package com.backend.backendFinal.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_type_id", referencedColumnName = "id")
    private PropertyType propertyType;

    private String propertyValue;


}
