package com.vivid.partnerships.interview.domain;

import com.vivid.partnerships.interview.controller.model.EventDTO;

import java.util.List;

public interface EventService {

    List<EventDTO> getEvents();
    EventDTO saveEvent(EventDTO eventDTO);
}
