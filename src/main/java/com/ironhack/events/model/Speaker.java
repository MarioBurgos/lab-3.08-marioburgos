package com.ironhack.events.model;

import jakarta.persistence.*;

import java.time.Duration;
import java.util.List;

@Entity
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Duration presentationDuration;
    @ManyToMany
    private List<Conference> conferences;

    public Speaker() {
    }

    public Speaker(String name, Duration presentationDuration, List<Conference> conferences) {
        this.name = name;
        this.presentationDuration = presentationDuration;
        this.conferences = conferences;
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

    public Duration getPresentationDuration() {
        return presentationDuration;
    }

    public void setPresentationDuration(Duration presentationDuration) {
        this.presentationDuration = presentationDuration;
    }

    public List<Conference> getConferences() {
        return conferences;
    }

    public void setConferences(List<Conference> conferences) {
        this.conferences = conferences;
    }
}
