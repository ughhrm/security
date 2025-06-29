package com.backend.backendFinal.controller;

import com.backend.backendFinal.model.dto.requestDto.BasketRequestDto;
import com.backend.backendFinal.model.dto.responseDto.BasketResponseDto;
import com.backend.backendFinal.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baskets")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @GetMapping
    public ResponseEntity<List<BasketResponseDto>> getAll() {
        return ResponseEntity.ok(basketService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BasketResponseDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(basketService.getById(id));
    }

    @PostMapping
    public ResponseEntity<BasketResponseDto> create(@RequestBody BasketRequestDto dto) {
        return ResponseEntity.ok(basketService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BasketResponseDto> update(@PathVariable Integer id, @RequestBody BasketRequestDto dto) {
        return ResponseEntity.ok(basketService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        basketService.delete(id);
        return ResponseEntity.noContent().build();
    }
}