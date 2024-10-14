package com.backend.backendFinal.repository;

import com.backend.backendFinal.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
