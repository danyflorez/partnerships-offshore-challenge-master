package com.vivid.partnerships.interview.database.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="venue")
public class Venue extends IdEntity{

    public String name;
    public String city;
    public String state;

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
