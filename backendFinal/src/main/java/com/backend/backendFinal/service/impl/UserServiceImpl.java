package com.backend.backendFinal.service.impl;

import com.backend.backendFinal.mapper.UserMapper;
import com.backend.backendFinal.model.dto.requestDto.CreateUserRequest;
import com.backend.backendFinal.model.dto.requestDto.UserRequestDto;
import com.backend.backendFinal.model.dto.responseDto.CategoryResponseDto;
import com.backend.backendFinal.model.dto.responseDto.UserResponseDto;
import com.backend.backendFinal.model.entity.Category;
import com.backend.backendFinal.model.security.User;
import com.backend.backendFinal.repository.UserRepository;
import com.backend.backendFinal.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElseThrow(EntityNotFoundException::new);
    }


    @Override
    public UserResponseDto register(CreateUserRequest request) {
        User user = User.builder()
                .firstName(request.name())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .city(request.city())
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .authorities(request.authorities())
                .isAccountNonExpired(true)
                .isEnabled(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .build();

        return userMapper.toEntityMapResponseDto(
                userRepository.save(user)
        );

    }
}
