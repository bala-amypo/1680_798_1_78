package com.example.demo.service;

import com.example.demo.model.Volunteer;
import java.util.List;
import java.util.Optional;

public interface VolunteerService {
    Volunteer createVolunteer(Volunteer volunteer);
    Optional<Volunteer> getVolunteerById(Long id);
    List<Volunteer> getAllVolunteers();
    Volunteer updateAvailability(Long volunteerId, boolean available);
}
