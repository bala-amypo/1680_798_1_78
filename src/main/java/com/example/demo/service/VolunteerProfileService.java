package com.example.demo.service;

import com.example.demo.model.Volunteer;
import java.util.List;

public interface VolunteerProfileService {

    Volunteer createVolunteer(Volunteer volunteer);

    Volunteer updateVolunteer(Volunteer volunteer);

    Volunteer getVolunteerById(Long id);

    List<Volunteer> getAllVolunteers();

    void deleteVolunteer(Long id);
}
