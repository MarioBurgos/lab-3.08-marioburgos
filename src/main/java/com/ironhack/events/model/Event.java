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
    private String date;
    private Duration duration;
    private String location;
    private String title;
    @ManyToMany(mappedBy = "events")
    private List<Guest> guestList;

    public Event() {
    }

    public Event(String date, Duration duration, String location, String title, List<Guest> guestList) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event event)) return false;

        if (getId() != null ? !getId().equals(event.getId()) : event.getId() != null) return false;
        if (getDate() != null ? !getDate().equals(event.getDate()) : event.getDate() != null) return false;
        if (getDuration() != null ? !getDuration().equals(event.getDuration()) : event.getDuration() != null)
            return false;
        if (getLocation() != null ? !getLocation().equals(event.getLocation()) : event.getLocation() != null)
            return false;
        if (getTitle() != null ? !getTitle().equals(event.getTitle()) : event.getTitle() != null) return false;
        return getGuestList() != null ? getGuestList().equals(event.getGuestList()) : event.getGuestList() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getDuration() != null ? getDuration().hashCode() : 0);
        result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getGuestList() != null ? getGuestList().hashCode() : 0);
        return result;
    }
}
