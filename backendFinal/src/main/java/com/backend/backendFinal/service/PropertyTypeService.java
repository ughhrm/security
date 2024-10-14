package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.OrderDto;
import com.backend.backendFinal.model.dto.PropertyTypeDto;
import com.backend.backendFinal.model.entity.PropertyType;

import java.util.List;

public interface PropertyTypeService {
    PropertyTypeDto getById(Integer id);
    PropertyTypeDto add(PropertyType propertyType);
    PropertyTypeDto update(PropertyType propertyType);
    void delete(Integer id);
    List<PropertyTypeDto> getPropertyTypeByCategoryId(Integer id);


}
