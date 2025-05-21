//package com.backend.backendFinal.controller;
//
//import com.backend.backendFinal.mapper.PropertyTypeMapper;
//import com.backend.backendFinal.mapper.PropertyTypeMapperImpl;
//import com.backend.backendFinal.model.dto.OrderDto;
//import com.backend.backendFinal.model.dto.PropertyTypeDto;
//import com.backend.backendFinal.model.dto.requestDto.PropertyTypeRequestDto;
//import com.backend.backendFinal.model.dto.responseDto.PropertyTypeResponseDto;
//import com.backend.backendFinal.model.entity.PropertyType;
//import com.backend.backendFinal.repository.PropertyTypeRepository;
//import com.backend.backendFinal.service.PropertyTypeService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/propertyType")
//@RequiredArgsConstructor
//public class PropertyTypeController {
//
//    private final PropertyTypeMapper propertyTypeMapper;
//    private final PropertyTypeService propertyTypeService;
//    @GetMapping("{id}")
//    public PropertyTypeResponseDto getById(@RequestParam Integer id){
//        return propertyTypeService.getById(id);
//    }
//    @PostMapping
//    public PropertyTypeResponseDto add(@RequestBody PropertyTypeRequestDto propertyTypeRequestDto){
//        return propertyTypeService.add(propertyTypeRequestDto);
//    }
//
//    @PutMapping
//    public PropertyTypeResponseDto update(@RequestBody PropertyTypeRequestDto propertyTypeRequestDto){
//        return propertyTypeService.update(propertyTypeRequestDto);
//    }
//    @DeleteMapping
//    public void delete(Integer id){
//        propertyTypeService.delete(id);
//    }
//
//    @GetMapping("/category/{id}")
//   public List<PropertyTypeResponseDto> getPropertyTypeByCategoryId(@PathVariable Integer id){
//        return propertyTypeService.getPropertyTypeByCategoryId(id);
//    }
//
//
//
//}
