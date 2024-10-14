package com.backend.backendFinal.repository;

import com.backend.backendFinal.model.dto.ProductPropertyDto;
import com.backend.backendFinal.model.entity.ProductProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductPropertyRepository extends JpaRepository<ProductProperty,Integer> {
    List<ProductProperty> findByProduct_Id(Integer id);
    List<ProductProperty> findByPropertyType_Id(Integer id);


}
