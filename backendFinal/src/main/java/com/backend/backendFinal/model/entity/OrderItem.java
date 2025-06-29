package com.backend.backendFinal.model.entity;

import com.backend.backendFinal.enums.DeliveryMethod;
import com.backend.backendFinal.enums.PaymentMethod;
import com.backend.backendFinal.enums.PaymentStatus;
import jakarta.persistence.*;

import java.sql.Timestamp;
@Entity
@Table(name = "orders")
public class OrderItem {
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

    @ManyToOne
    private Product product;

    @ManyToOne
    private Order order;
}
