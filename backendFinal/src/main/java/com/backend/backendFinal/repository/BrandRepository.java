package com.backend.backendFinal.repository;

import com.backend.backendFinal.model.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
