package com.vivid.partnerships.interview.controller.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class EventDTO {
    public Integer id;
    @NotNull(message = "Event Name should not be null")
    @Size(max = 255)
    public String name;
    @NotNull(message = "Event Date should not be null")
    public LocalDate date;
    @NotNull(message = "Event Venue should not be null")
    public VenueDTO venue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public VenueDTO getVenue() {
        return venue;
    }

    public void setVenue(VenueDTO venue) {
        this.venue = venue;
    }
}
