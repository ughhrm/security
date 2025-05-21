//package com.backend.backendFinal.service.impl;
//
//import com.backend.backendFinal.mapper.BrandMapper;
//import com.backend.backendFinal.model.dto.BrandDto;
//import com.backend.backendFinal.model.entity.Brand;
//import com.backend.backendFinal.repository.BrandRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class BrandServerImplTest {
//
//    @InjectMocks
//    BrandServerImpl brandServer;
//
//    @Mock
//    BrandRepository brandRepository;
//    @Mock
//    BrandMapper brandMapper;
//
//    private BrandDto brandDto;
//    private Brand brand;
//
//    @BeforeEach
//    void setUp() {
//        brand = new Brand();
//        brand.setId(1);
//        brand.setName("Samsung");
//
//        brandDto = new BrandDto();
//        brandDto.setId(1);
//        brandDto.setName("Samsung");
//    }
//
//    @AfterEach
//    void tearDown() {
//        brand = null;
//        brandDto = null;
//    }
//
//    @Test
//    void getBrandById() {
//        //Arrange
//        when(brandRepository.findById(anyInt())).thenReturn(Optional.of(brand));
//        when(brandMapper.toEntityMapResponseDto(brand)).thenReturn(brandDto);
//
//        //Act
//        BrandDto brandDto1 = brandServer.getBrandById(1);
//
//        //Assert
//        assertThat(brandDto1.getId()).isEqualTo(1);
//        assertThat(brandDto1.getName()).isEqualTo("Samsung");
//
//        //Verify
//        verify(brandRepository, times(1)).findById(1);
//        verify(brandMapper, times(1)).toEntityMapResponseDto(brand);
//
//
//    }
//
//    @Test
//    void add() {
//        //Arrange
//        when(brandRepository.save(any())).thenReturn(brand);
//        when(brandMapper.toEntityMapResponseDto(brand)).thenReturn(brandDto);
//        //Act
//        BrandDto brandDto1 = brandServer.add(brand);
//        //Assert
//        assertEquals(brandDto, brandDto1);
//        //verify
//        verify(brandRepository, times(1)).save(brand);
//        verify(brandMapper, times(1)).toEntityMapResponseDto(brand);
//
//    }
//    @Test
//    void update(){
//        when(brandRepository.save(any())).thenReturn(brand);
//        when(brandMapper.toEntityMapResponseDto(brand)).thenReturn(brandDto);
//
//        BrandDto brandDto1 =brandServer.update(brand);
//
//        assertEquals(brandDto,brandDto1);
//
//        verify(brandRepository,times(1)).save(brand);
//        verify(brandMapper,times(1)).toEntityMapResponseDto(brand);
//    }
//
//    @Test
//    void delete() {
//        Integer id=1;
//        brandServer.delete(id);
//        verify(brandRepository,times(1)).deleteById(id);
//    }
//}