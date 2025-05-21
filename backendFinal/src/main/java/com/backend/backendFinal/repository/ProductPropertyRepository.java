package com.backend.backendFinal.repository;

import com.backend.backendFinal.model.dto.ProductPropertyDto;
import com.backend.backendFinal.model.entity.Product;
import com.backend.backendFinal.model.entity.ProductProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductPropertyRepository extends JpaRepository<ProductProperty,Integer> {

}
