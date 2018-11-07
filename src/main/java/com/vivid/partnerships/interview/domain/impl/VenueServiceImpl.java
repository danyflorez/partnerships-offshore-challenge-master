package com.vivid.partnerships.interview.domain.impl;

import com.vivid.partnerships.interview.controller.model.VenueDTO;
import com.vivid.partnerships.interview.database.VenueRepository;
import com.vivid.partnerships.interview.database.entity.Venue;
import com.vivid.partnerships.interview.domain.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueServiceImpl implements VenueService {

    private final VenueRepository venueRepository;

    @Autowired
    public VenueServiceImpl(VenueRepository venueRepository){
        this.venueRepository = venueRepository;
    }

    @Override
    public Venue save(VenueDTO venueDto) {
        return venueRepository.save(venueDTOToVenue(venueDto));
    }

    private Venue venueDTOToVenue(VenueDTO venueDTO){
        Venue venue = new Venue();
        venue.setCity(venueDTO.getCity());
        venue.setName(venueDTO.getName());
        venue.setState(venueDTO.getState());
        venue.setId(venueDTO.getId());
        return venue;
    }
}
