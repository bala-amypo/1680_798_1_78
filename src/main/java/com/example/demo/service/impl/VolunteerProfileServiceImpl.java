package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.model.Volunteer;
import com.example.demo.service.VolunteerProfileService;

import java.util.ArrayList;
import java.util.List;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private List<Volunteer> volunteers = new ArrayList<>();

    @Override
    public Volunteer createVolunteer(Volunteer volunteer) {
        volunteers.add(volunteer);
        return volunteer;
    }

    @Override
    public Volunteer updateVolunteerAvailability(Long volunteerId, boolean available) {
        for (Volunteer v : volunteers) {
            if (v.getId().equals(volunteerId)) {
                v.setAvailabilityStatus(available);
                return v;
            }
        }
        return null;
    }

    @Override
    public Volunteer getVolunteerById(Long id) {
        return volunteers.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Volunteer> getAllVolunteers() {
        return volunteers;
    }
}
