package com.vivid.partnerships.interview.database.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="events")
public class Event extends IdEntity{

    public String name;
    public LocalDate date;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="venue_id")
    public Venue venue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
