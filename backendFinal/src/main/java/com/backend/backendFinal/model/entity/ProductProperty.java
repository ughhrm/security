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

    private String propertyValue;

    @ManyToMany(mappedBy = "productProperties")
    private List<Product> products;


//    @ManyToOne
//    @JoinColumn(name = "property_type_id", referencedColumnName = "id")
//    private PropertyType propertyType;
}
