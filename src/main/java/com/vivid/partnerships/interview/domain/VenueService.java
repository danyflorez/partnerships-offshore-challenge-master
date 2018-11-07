package com.vivid.partnerships.interview.domain;

import com.vivid.partnerships.interview.controller.model.VenueDTO;
import com.vivid.partnerships.interview.database.entity.Venue;

public interface VenueService {

    Venue save(VenueDTO venue);
}
