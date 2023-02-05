package com.ironhack.events.repositories;

import com.ironhack.events.model.Guest;
import com.ironhack.events.model.enums.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GuestRepositoryTest {

    private GuestRepository guestRepository;
    private Guest guest;
    @BeforeEach
    void setUp() {
        guest = new Guest("Guest", Status.NO_RESPONSE, null);
        guestRepository.save(guest);
    }

    @AfterEach
    void tearDown() {
        guestRepository.deleteAll();
    }

    @Test
    void JPA_Testing(){
        Optional<Guest> optionalGuest = guestRepository.findById(guest.getId());
        assertEquals(optionalGuest.get().getName(), "Guest");
    }
}