package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.requestDto.WishlistRequestDto;
import com.backend.backendFinal.model.dto.responseDto.WishlistResponseDto;
import com.backend.backendFinal.model.entity.Wishlist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")

public interface WishlistMapper {
    Wishlist toRequestDtoMapEntity(WishlistRequestDto wishlistRequestDto);

    WishlistResponseDto toEntityMapResponseDto(Wishlist wishlist);

}
