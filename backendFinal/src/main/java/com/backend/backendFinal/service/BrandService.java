package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.requestDto.BrandRequestDto;
import com.backend.backendFinal.model.dto.responseDto.BrandResponseDto;

import java.util.List;

public interface BrandService {
    List<BrandResponseDto> getAll();
    BrandResponseDto getBrandById(Integer id);
    BrandResponseDto add(BrandRequestDto dto);
    BrandResponseDto update(Integer id, BrandRequestDto dto);
    void delete(Integer id);
}