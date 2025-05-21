package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.BrandDto;
import com.backend.backendFinal.model.dto.responseDto.BrandResponseDto;
import com.backend.backendFinal.model.entity.Brand;

public interface BrandService {
    BrandResponseDto  getBrandById(Integer id);

    BrandResponseDto  add(Brand brand);

    BrandResponseDto update(Brand brand);

    void delete(Integer id);

}
