package com.example.demo.service;

import com.example.demo.dto.AvailabilityUpdateRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.VolunteerProfile;

import java.util.List;

public interface VolunteerProfileService {

    VolunteerProfile registerVolunteer(RegisterRequest request);

    VolunteerProfile updateAvailability(Long volunteerId,
                                        AvailabilityUpdateRequest request);

    VolunteerProfile getVolunteer(Long id);

    List<VolunteerProfile> getAllVolunteers();
}
