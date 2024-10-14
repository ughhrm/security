package com.backend.backendFinal.model.dto;

import com.backend.backendFinal.enums.DeliveryMethod;
import com.backend.backendFinal.enums.PaymentMethod;
import com.backend.backendFinal.enums.PaymentStatus;
import com.backend.backendFinal.model.entity.Customer;
import com.backend.backendFinal.model.entity.Product;
import lombok.Data;

import java.sql.Timestamp;


@Data
public class OrderDto {

    private Integer id;

    private Timestamp createTime;

    private Integer quantity;

    private DeliveryMethod deliveryMethod;

    private PaymentMethod paymentMethod;

    private Integer price;

    private PaymentStatus paymentStatus;

    private Customer customer;

    private Product product;


}
