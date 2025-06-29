package com.backend.backendFinal.model.entity;

import com.backend.backendFinal.enums.DeliveryMethod;
import com.backend.backendFinal.enums.PaymentMethod;
import com.backend.backendFinal.enums.PaymentStatus;
import com.backend.backendFinal.model.security.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp createTime;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;



}
