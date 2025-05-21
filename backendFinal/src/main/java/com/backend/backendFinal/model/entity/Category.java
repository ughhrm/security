package com.backend.backendFinal.model.entity;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;



}
