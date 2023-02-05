package com.ironhack.events.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.time.Duration;
import java.util.Date;
import java.util.List;


@Entity
public class Conference extends Event{
    @ManyToMany(mappedBy = "conferences")
    private List<Speaker> speakers;

    public Conference() {
    }

    public Conference(String date, Duration duration, String location, String title, List<Guest> guestList, List<Speaker> speakers) {
        super(date, duration, location, title, guestList);
        this.speakers = speakers;
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }
}
