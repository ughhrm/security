package com.backend.backendFinal.repository;

import com.backend.backendFinal.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {


}
