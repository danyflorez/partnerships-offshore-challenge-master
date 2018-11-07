package com.vivid.partnerships.interview.controller;

import com.vivid.partnerships.interview.controller.model.EventDTO;
import com.vivid.partnerships.interview.domain.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    private final EventService eventService;

    @Autowired
    public EventController(final EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<EventDTO> getEvents() {
        List<EventDTO> events = eventService.getEvents();
        LOGGER.info("Returning {} events", events.size());
        return events;
    }

    @PostMapping
    public EventDTO saveEvents(@Valid @RequestBody EventDTO eventDTO){
        return eventService.saveEvent(eventDTO);
    }
}
