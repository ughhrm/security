package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.BrandMapper;
import com.backend.backendFinal.model.dto.BrandDto;
import com.backend.backendFinal.model.entity.Brand;
import com.backend.backendFinal.repository.BrandRepository;
import com.backend.backendFinal.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandServerImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;
    @Override
    public BrandDto getBrandById(Integer id) {
        return brandMapper.toBrandDto(brandRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    @Override
    public BrandDto add(Brand brand) {
        return brandMapper.toBrandDto(brandRepository.save(brand));
    }

    @Override
    public BrandDto update(Brand brand) {
        return brandMapper.toBrandDto(brandRepository.save(brand));
    }

    @Override
    public void delete(Integer id) {
        brandRepository.deleteById(id);
    }
}
