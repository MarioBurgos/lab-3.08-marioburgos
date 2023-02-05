package com.ironhack.events.model;

import com.ironhack.association.model.District;
import jakarta.persistence.*;

import java.time.Duration;
import java.util.Date;
import java.util.List;

@Entity
public abstract class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Duration duration;
    private String location;
    private String title;
    @ManyToMany(mappedBy = "events")
    private List<Guest> guestList;

    public Event() {
    }

    public Event(Date date, Duration duration, String location, String title, List<Guest> guestList) {
        this.date = date;
        this.duration = duration;
        this.location = location;
        this.title = title;
        this.guestList = guestList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Duration getDuration() {
        return duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }
}
