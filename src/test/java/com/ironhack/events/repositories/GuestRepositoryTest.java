package com.ironhack.events.repositories;

import com.ironhack.events.model.Event;
import com.ironhack.events.model.Exposition;
import com.ironhack.events.model.Guest;
import com.ironhack.events.model.enums.Status;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestRepositoryTest {
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private EventRepository eventRepository;
    private Guest guest;
    private Event event;

    @BeforeEach
    void setUp() {
        event = new Exposition("05/02/2022", Duration.ofMinutes(60),"location", "event-expo", null);
        guest = new Guest("Guest", Status.NO_RESPONSE, null);
        eventRepository.save(event);

        guest.setEvents(List.of(event));
        guestRepository.save(guest);

        event.setGuestList(List.of(guest));
        eventRepository.save(event);
    }

    @AfterEach
    void tearDown() {
        guest.setEvents(null);
        guestRepository.save(guest);
        event.setGuestList(null);
        eventRepository.save(event);
        guestRepository.deleteAll();
        eventRepository.deleteAll();

    }

    @Test
    void JPA_Testing() {
        Optional<Guest> optionalGuest = guestRepository.findById(guest.getId());
        assertEquals(optionalGuest.get().getName(), "Guest");
        assertThrows(LazyInitializationException.class, ()-> optionalGuest.get().getEvents().get(0));
    }

    @Test
    void findByIdWithEvents() {
        Optional<Guest> optionalGuest = guestRepository.findByIdWithEvents(guest.getId());
        assertEquals(optionalGuest.get().getEvents().get(0).getDate(), event.getDate());
        assertEquals(optionalGuest.get().getEvents().get(0).getDuration(), event.getDuration());
        assertEquals(optionalGuest.get().getEvents().get(0).getTitle(), event.getTitle());
        assertEquals(optionalGuest.get().getEvents().get(0).getId(), event.getId());
        // todo : check equals overriding because the next line fails
        //assertEquals(optionalGuest.get().getEvents().get(0), event);
    }
}