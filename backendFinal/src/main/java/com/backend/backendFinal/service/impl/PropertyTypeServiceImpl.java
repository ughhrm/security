//package com.backend.backendFinal.service.impl;
//
//import com.backend.backendFinal.mapper.PropertyTypeMapper;
//import com.backend.backendFinal.model.dto.PropertyTypeDto;
//import com.backend.backendFinal.model.dto.requestDto.PropertyTypeRequestDto;
//import com.backend.backendFinal.model.dto.responseDto.PropertyTypeResponseDto;
//import com.backend.backendFinal.model.entity.PropertyType;
//import com.backend.backendFinal.repository.PropertyTypeRepository;
//import com.backend.backendFinal.service.PropertyTypeService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class PropertyTypeServiceImpl implements PropertyTypeService {
//    private final PropertyTypeMapper propertyTypeMapper;
//    private final PropertyTypeRepository propertyTypeRepository;
//
//    @Override
//    public PropertyTypeResponseDto getById(Integer id) {
//       PropertyType propertyType =propertyTypeRepository.findById(id).orElseThrow(NullPointerException::new);
//       PropertyTypeResponseDto propertyTypeResponseDto = propertyTypeMapper.toEntityMapResponseDto(propertyType);
//       return propertyTypeResponseDto;
//    }
//
//    @Override
//    public PropertyTypeResponseDto add(PropertyTypeRequestDto propertyTypeRequestDto) {
//        PropertyType propertyType =propertyTypeMapper.toRequestDtoMapEntity(propertyTypeRequestDto);
//        propertyTypeRepository.save(propertyType);
//        PropertyTypeResponseDto propertyTypeResponseDto =propertyTypeMapper.toEntityMapResponseDto(propertyType);
//
//        return  propertyTypeResponseDto;
//    }
//
//    @Override
//    public PropertyTypeResponseDto update(PropertyTypeRequestDto propertyTypeRequestDto) {
//        PropertyType propertyType =propertyTypeMapper.toRequestDtoMapEntity(propertyTypeRequestDto);
//        propertyTypeRepository.save(propertyType);
//        PropertyTypeResponseDto propertyTypeResponseDto =propertyTypeMapper.toEntityMapResponseDto(propertyType);
//
//        return  propertyTypeResponseDto;    }
//
//    @Override
//    public void delete(Integer id) {
//        propertyTypeRepository.deleteById(id);
//
//    }
//
//    @Override
//    public List<PropertyTypeResponseDto> getPropertyTypeByCategoryId(Integer id) {
//        return propertyTypeRepository.findByCategory_Id(id).stream().map(propertyTypeMapper::toEntityMapResponseDto).toList();
//    }
//
//}
