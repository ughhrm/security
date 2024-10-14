package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.BrandDto;
import com.backend.backendFinal.model.entity.Brand;

public interface BrandService {
    BrandDto getBrandById(Integer id);

    BrandDto add(Brand brand);

    BrandDto update(Brand brand);

    void delete(Integer id);

}
