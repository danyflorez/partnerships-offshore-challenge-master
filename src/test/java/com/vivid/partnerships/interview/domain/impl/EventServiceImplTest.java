package com.vivid.partnerships.interview.domain.impl;

import com.vivid.partnerships.interview.DataUtil;
import com.vivid.partnerships.interview.controller.model.EventDTO;
import com.vivid.partnerships.interview.controller.model.VenueDTO;
import com.vivid.partnerships.interview.database.EventRepository;
import com.vivid.partnerships.interview.database.entity.Event;
import com.vivid.partnerships.interview.database.entity.Venue;
import com.vivid.partnerships.interview.domain.VenueService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceImplTest {

    @InjectMocks
    private EventServiceImpl eventService;

    @Mock
    private VenueService venueService;

    @Mock
    private EventRepository eventRepository;

    @Captor
    private ArgumentCaptor<Event> eventCaptor;

    @Captor
    private ArgumentCaptor<Venue> venueCaptor;

    @Test
    public void shouldFindAndConvertAllEvents(){
        Mockito.when(eventRepository.findAll()).thenReturn(Arrays.asList(DataUtil.getEventEntity()));

        List<EventDTO> events = eventService.getEvents();

        EventDTO eventDTO = events.get(0);
        assertEventDTOValues(eventDTO);
    }

    @Test
    public void shouldConvertAndSaveEventAndVenue(){

        EventDTO eventDTO = DataUtil.getEventDTO();
        Venue venueEntity = DataUtil.getVenueEntity();
        Event eventEntity = DataUtil.getEventEntity();
        Mockito.when(venueService.save(eventDTO.getVenue())).thenReturn(venueEntity);
        Mockito.when(eventRepository.save(Mockito.any())).thenReturn(eventEntity);

        EventDTO eventResponse = eventService.saveEvent(eventDTO);

        Mockito.verify(eventRepository).save(eventCaptor.capture());
        Event event = eventCaptor.getValue();
        assertEventEntityValues(event);
        assertEventDTOValues(eventResponse);

    }

    private void assertEventDTOValues(EventDTO eventDTO) {
        Assertions.assertThat(eventDTO.getName()).isEqualTo("Spring");
        Assertions.assertThat(eventDTO.getDate()).isEqualTo(LocalDate.of(2018, 1, 1));
        Assertions.assertThat(eventDTO.getId()).isEqualTo(1);

        VenueDTO venue = eventDTO.getVenue();

        Assertions.assertThat(venue.getName()).isEqualTo("Wall street");
        Assertions.assertThat(venue.getCity()).isEqualTo("Miami");
        Assertions.assertThat(venue.getState()).isEqualTo("FL");
        Assertions.assertThat(venue.getId()).isEqualTo(4);
    }

    private void assertEventEntityValues(Event event) {
        Assertions.assertThat(event.getName()).isEqualTo("Spring");
        Assertions.assertThat(event.getDate()).isEqualTo(LocalDate.of(2018, 1, 1));
        Assertions.assertThat(event.getId()).isEqualTo(1);

        Venue venue = event.getVenue();

        Assertions.assertThat(venue.getName()).isEqualTo("Wall street");
        Assertions.assertThat(venue.getCity()).isEqualTo("Miami");
        Assertions.assertThat(venue.getState()).isEqualTo("FL");
        Assertions.assertThat(venue.getId()).isEqualTo(4);
    }

}
