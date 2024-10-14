package com.backend.backendFinal.repository;

import com.backend.backendFinal.model.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ShopRepository extends JpaRepository<Shop,Integer>{
}
