package com.vivid.partnerships.interview.controller.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class VenueDTO {
    public Integer id;
    @NotNull(message = "Venue Name should not be null")
    @Size(max = 255)
    public String name;
    @NotNull(message = "Venue City should not be null")
    @Size(max = 255)
    public String city;
    @Size(max = 255)
    @NotNull(message = "Venue State should not be null")
    public String state;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
