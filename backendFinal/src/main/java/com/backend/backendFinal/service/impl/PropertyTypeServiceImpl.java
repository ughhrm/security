package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.PropertyTypeMapper;
import com.backend.backendFinal.model.dto.PropertyTypeDto;
import com.backend.backendFinal.model.entity.PropertyType;
import com.backend.backendFinal.repository.PropertyTypeRepository;
import com.backend.backendFinal.service.PropertyTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyTypeServiceImpl implements PropertyTypeService {
    private final PropertyTypeMapper propertyTypeMapper;
    private final PropertyTypeRepository propertyTypeRepository;

    @Override
    public PropertyTypeDto getById(Integer id) {
        return propertyTypeMapper.toPropertyTypeDto(propertyTypeRepository.findById(id)
                .orElseThrow(NullPointerException::new));
    }

    @Override
    public PropertyTypeDto add(PropertyType propertyType) {
        return  propertyTypeMapper.toPropertyTypeDto(propertyTypeRepository.save(propertyType));
    }

    @Override
    public PropertyTypeDto update(PropertyType propertyType) {
        return propertyTypeMapper.toPropertyTypeDto(propertyTypeRepository.save(propertyType));
    }

    @Override
    public void delete(Integer id) {
        propertyTypeRepository.deleteById(id);

    }

    @Override
    public List<PropertyTypeDto> getPropertyTypeByCategoryId(Integer id) {
        return propertyTypeRepository.findByCategory_Id(id).stream().map(propertyTypeMapper::toPropertyTypeDto).toList();
    }

}
