package com.ironhack.repositories;

import com.ironhack.model.District;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DistrictRepositoryTest {
    @Autowired
    private DistrictRepository districtRepository;
    private District district;

    @BeforeEach
    void setUp() {
        district = new District("08940");
        districtRepository.save(district);
    }

    @AfterEach
    void tearDown() {
        districtRepository.deleteAll();
    }

    @Test
    void JPAIsOkeey_ThenLesGoo(){
        Optional<District> optionalDistrict = districtRepository.findById(district.getId());
        assertEquals("08940", optionalDistrict.get().getPostalCode());
    }
}