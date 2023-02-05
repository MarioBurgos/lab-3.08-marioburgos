package com.ironhack.events.model;

import com.ironhack.events.model.enums.Status;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToMany
    private List<Event> events;

    public Guest() {
    }

    public Guest(String name, Status status, List<Event> events) {
        this.name = name;
        this.status = status;
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest guest)) return false;

        if (getId() != null ? !getId().equals(guest.getId()) : guest.getId() != null) return false;
        if (getName() != null ? !getName().equals(guest.getName()) : guest.getName() != null) return false;
        if (getStatus() != guest.getStatus()) return false;
        return getEvents() != null ? getEvents().equals(guest.getEvents()) : guest.getEvents() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getEvents() != null ? getEvents().hashCode() : 0);
        return result;
    }
}
