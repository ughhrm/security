package com.backend.backendFinal.repository;

import com.backend.backendFinal.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByCategory_Id(Integer id);
    List<Product> findByBrand_Id(Integer id);
}
