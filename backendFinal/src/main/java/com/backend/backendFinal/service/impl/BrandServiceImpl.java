package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.BrandMapper;
import com.backend.backendFinal.model.dto.requestDto.BrandRequestDto;
import com.backend.backendFinal.model.dto.responseDto.BrandResponseDto;
import com.backend.backendFinal.model.entity.Brand;
import com.backend.backendFinal.repository.BrandRepository;
import com.backend.backendFinal.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Override
    public List<BrandResponseDto> getAll() {
        return brandRepository.findAll()
                .stream()
                .map(brandMapper::toEntityMapResponseDto)
                .toList();
    }

    @Override
    public BrandResponseDto getBrandById(Integer id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        return brandMapper.toEntityMapResponseDto(brand);
    }

    @Override
    public BrandResponseDto add(BrandRequestDto dto) {
        Brand brand = brandMapper.toRequestDtoMapEntity(dto);
        Brand saved = brandRepository.save(brand);
        return brandMapper.toEntityMapResponseDto(saved);
    }

    @Override
    public BrandResponseDto update(Integer id, BrandRequestDto dto) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        brand.setName(dto.getName());
        Brand updated = brandRepository.save(brand);
        return brandMapper.toEntityMapResponseDto(updated);
    }

    @Override
    public void delete(Integer id) {
        brandRepository.deleteById(id);
    }
}
