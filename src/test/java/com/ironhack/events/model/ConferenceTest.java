package com.ironhack.events.model;

import com.ironhack.events.model.enums.Status;
import com.ironhack.events.repositories.ConferenceRepository;
import com.ironhack.events.repositories.GuestRepository;
import com.ironhack.events.repositories.SpeakerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ConferenceTest {

    @Autowired
    private ConferenceRepository conferenceRepository;
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private SpeakerRepository speakerRepository;
    private Conference conference;
    private Guest guest1, guest2;
    private Speaker speaker1, speaker2;
    @BeforeEach
    void setUp() {
        guest1 = new Guest("guest1", Status.NO_RESPONSE, null);
        guest2 = new Guest("guest2", Status.ATTENDING, null);
        guestRepository.save(guest1);
        guestRepository.save(guest2);

        speaker1 = new Speaker("speaker1", Duration.ofMinutes(80), null);
        speaker2 = new Speaker("speaker2", Duration.ofMinutes(40), null);
        speakerRepository.save(speaker1);
        speakerRepository.save(speaker2);

        conference = new Conference(new Date(2023-05-02), Duration.ofMinutes(120), "Location", "Title", List.of(guest1, guest2), List.of(speaker1,speaker2));
        conferenceRepository.save(conference);
    }

    @AfterEach
    void tearDown() {
    }


}