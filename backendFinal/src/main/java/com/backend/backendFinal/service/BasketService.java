package com.backend.backendFinal.service;

import com.backend.backendFinal.model.dto.requestDto.BasketRequestDto;
import com.backend.backendFinal.model.dto.responseDto.BasketResponseDto;

import java.util.List;

public interface BasketService {
    List<BasketResponseDto> getAll();
    BasketResponseDto getById(Integer id);
    BasketResponseDto create(BasketRequestDto dto);
    BasketResponseDto update(Integer id, BasketRequestDto dto);
    void delete(Integer id);
}
