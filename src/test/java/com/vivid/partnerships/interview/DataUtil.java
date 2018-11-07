package com.vivid.partnerships.interview;

import com.vivid.partnerships.interview.controller.model.EventDTO;
import com.vivid.partnerships.interview.controller.model.VenueDTO;
import com.vivid.partnerships.interview.database.entity.Event;
import com.vivid.partnerships.interview.database.entity.Venue;

import java.time.LocalDate;

public final class DataUtil {

    private DataUtil(){

    }

    public static EventDTO getEventDTO() {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setName("Spring");
        eventDTO.setId(1);
        eventDTO.setDate(LocalDate.of(2018, 1, 1));
        VenueDTO venueDTO = new VenueDTO();
        venueDTO.setState("FL");
        venueDTO.setId(4);
        venueDTO.setCity("Miami");
        venueDTO.setName("Wall street");
        eventDTO.setVenue(venueDTO);
        return eventDTO;
    }

    public static Event getEventEntity() {
        Event event = new Event();
        event.setName("Spring");
        event.setId(1);
        event.setDate(LocalDate.of(2018, 1, 1));
        Venue venue = new Venue();
        venue.setState("FL");
        venue.setId(4);
        venue.setCity("Miami");
        venue.setName("Wall street");
        event.setVenue(venue);
        return event;
    }

    public static Venue getVenueEntity() {
        Venue venue = new Venue();
        venue.setState("FL");
        venue.setId(4);
        venue.setCity("Miami");
        venue.setName("Wall street");
        return venue;
    }
}
