package com.backend.backendFinal.mapper;

import com.backend.backendFinal.model.dto.requestDto.CategoryRequestDto;
import com.backend.backendFinal.model.dto.requestDto.UserRequestDto;
import com.backend.backendFinal.model.dto.responseDto.CategoryResponseDto;
import com.backend.backendFinal.model.dto.responseDto.UserResponseDto;
import com.backend.backendFinal.model.entity.Category;
import com.backend.backendFinal.model.security.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toRequestDtoMapEntity(UserRequestDto userRequestDto);
    UserResponseDto toEntityMapResponseDto(User user);

}
