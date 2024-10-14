package com.backend.backendFinal.model.entity;

import com.backend.backendFinal.enums.DeliveryMethod;
import com.backend.backendFinal.enums.PaymentMethod;
import com.backend.backendFinal.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.sql.Timestamp;


@Entity
@Data
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp createTime;
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private DeliveryMethod deliveryMethod;


    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private Integer price;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

}
