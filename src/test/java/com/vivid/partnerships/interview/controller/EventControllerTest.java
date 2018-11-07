package com.vivid.partnerships.interview.controller;

import com.vivid.partnerships.interview.DataUtil;
import com.vivid.partnerships.interview.controller.model.EventDTO;
import com.vivid.partnerships.interview.domain.EventService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({EventController.class})
public class EventControllerTest {

    private static final String JSON_LIST_EVENT = "[{\"id\":1,\"name\":\"Spring\",\"date\":\"2018-01-01\",\"venue\":{\"id\":4,\"name\":\"Wall street\",\"city\":\"Miami\",\"state\":\"FL\"}}]";
    private static final String JSON_EVENT = "{\"name\":\"Spring\",\"date\":\"2018-01-01\",\"venue\":{\"name\":\"Wall street\",\"city\":\"Miami\",\"state\":\"FL\"}}";
    private static final String JSON_RESONSE_EVENT = "{\"id\":1,\"name\":\"Spring\",\"date\":\"2018-01-01\",\"venue\":{\"id\":4,\"name\":\"Wall street\",\"city\":\"Miami\",\"state\":\"FL\"}}";
    private static final String JSON_EVENT_BAD_REQUEST = "{\"name\":\"Spring\",\"date\":\"2018-01-01\"}";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventService eventService;

    @Test
    public void shouldListAllEvents() throws Exception {
        EventDTO event = DataUtil.getEventDTO();
        Mockito.when(eventService.getEvents()).thenReturn(Arrays.asList(event));

        mockMvc.perform(get("/events")).andExpect(status().isOk())
                                        .andExpect(content().string(containsString(JSON_LIST_EVENT)));
    }

    @Test
    public void shouldSaveTheEvent() throws Exception {
        EventDTO event = DataUtil.getEventDTO();
        Mockito.when(eventService.saveEvent(Mockito.any())).thenReturn(event);

        mockMvc.perform(post("/events")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON_EVENT))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(JSON_RESONSE_EVENT)));
    }

    @Test
    public void shouldReturnBadRequestWhenThereIsNoVenue() throws Exception {

        mockMvc.perform(post("/events")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON_EVENT_BAD_REQUEST))
                .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
    }


}
