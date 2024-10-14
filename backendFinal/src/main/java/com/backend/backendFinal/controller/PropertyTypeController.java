package com.backend.backendFinal.controller;

import com.backend.backendFinal.mapper.PropertyTypeMapper;
import com.backend.backendFinal.mapper.PropertyTypeMapperImpl;
import com.backend.backendFinal.model.dto.OrderDto;
import com.backend.backendFinal.model.dto.PropertyTypeDto;
import com.backend.backendFinal.model.entity.PropertyType;
import com.backend.backendFinal.repository.PropertyTypeRepository;
import com.backend.backendFinal.service.PropertyTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propertyType")
@RequiredArgsConstructor
public class PropertyTypeController {

    private final PropertyTypeMapper propertyTypeMapper;
    private final PropertyTypeService propertyTypeService;
    @GetMapping("{id}")
    public PropertyTypeDto getById(@RequestParam Integer id){
        return propertyTypeService.getById(id);
    }
    @PostMapping
    public PropertyTypeDto add(@RequestBody PropertyType propertyType){
        return propertyTypeService.add(propertyType);
    }

    @PutMapping
    public PropertyTypeDto update(@RequestBody PropertyType propertyType){
        return propertyTypeService.update(propertyType);
    }
    @DeleteMapping
    public void delete(Integer id){
        propertyTypeService.delete(id);
    }

    @GetMapping("/category/{id}")
   public List<PropertyTypeDto> getPropertyTypeByCategoryId(@PathVariable Integer id){
        return propertyTypeService.getPropertyTypeByCategoryId(id);
    }



}
