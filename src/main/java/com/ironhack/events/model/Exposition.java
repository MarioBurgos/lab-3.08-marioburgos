package com.ironhack.events.model;

import jakarta.persistence.Entity;

import java.time.Duration;
import java.util.Date;
import java.util.List;
@Entity
public class Exposition extends Event{

    public Exposition() {
    }

    public Exposition(Date date, Duration duration, String location, String title, List<Guest> guestList) {
        super(date, duration, location, title, guestList);
    }
}
