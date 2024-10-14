package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.PropertyTypeDto;
import com.backend.backendFinal.model.entity.PropertyType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PropertyTypeMapper {
    PropertyTypeDto  toPropertyTypeDto(PropertyType propertyType);
}
