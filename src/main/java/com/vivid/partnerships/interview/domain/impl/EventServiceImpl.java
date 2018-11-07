package com.vivid.partnerships.interview.domain.impl;


import com.vivid.partnerships.interview.controller.model.EventDTO;
import com.vivid.partnerships.interview.controller.model.VenueDTO;
import com.vivid.partnerships.interview.database.EventRepository;
import com.vivid.partnerships.interview.database.entity.Event;
import com.vivid.partnerships.interview.database.entity.Venue;
import com.vivid.partnerships.interview.domain.EventService;
import com.vivid.partnerships.interview.domain.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final VenueService venueService;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, VenueService venueService) {
        this.eventRepository = eventRepository;
        this.venueService = venueService;
    }

    public List<EventDTO> getEvents() {
         return eventRepository.findAll()
                                .stream()
                                .map(this::eventEntityToEventDTO)
                                .collect(Collectors.toList());
    }

    @Transactional
    public EventDTO saveEvent(EventDTO eventDTO){
        Venue venue = venueService.save(eventDTO.getVenue());
        Event event = eventDTOToEventEntity(eventDTO);
        event.setVenue(venue);
        Event eventSaved = eventRepository.save(event);
        return eventEntityToEventDTO(eventSaved);
    }

    private EventDTO eventEntityToEventDTO(Event event){
        EventDTO eventDTO = new EventDTO();
        eventDTO.setDate(event.getDate());
        eventDTO.setId(event.getId());
        eventDTO.setName(event.getName());
        VenueDTO venueDTO = new VenueDTO();
        venueDTO.setCity(event.getVenue().getCity());
        venueDTO.setName(event.getVenue().getName());
        venueDTO.setState(event.getVenue().getState());
        venueDTO.setId(event.getVenue().getId());
        eventDTO.setVenue(venueDTO);
        return eventDTO;
    }


    private Event eventDTOToEventEntity(EventDTO eventDTO){
        Event event = new Event();
        event.setDate(eventDTO.getDate());
        event.setId(eventDTO.getId());
        event.setName(eventDTO.getName());
        return event;
    }

}
