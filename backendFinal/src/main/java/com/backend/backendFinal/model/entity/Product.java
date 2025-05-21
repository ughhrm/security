package com.backend.backendFinal.model.entity;

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

    @ManyToMany
    @JoinTable(name = "product_productProperty", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "productProperty_id"))
    private List<ProductProperty> productProperties;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", referencedColumnName ="id")
    private Brand brand;




}
