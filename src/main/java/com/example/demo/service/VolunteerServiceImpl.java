package com.example.demo.service;

import com.example.demo.model.Volunteer;
import com.example.demo.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VolunteerServiceImpl implements VolunteerService {

    @Autowired
    private VolunteerRepository volunteerRepository;

    @Override
    public Volunteer createVolunteer(Volunteer volunteer) {
        // You can add validation for unique email/phone here
        return volunteerRepository.save(volunteer);
    }

    @Override
    public Optional<Volunteer> getVolunteerById(Long id) {
        return volunteerRepository.findById(id);
    }

    @Override
    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    @Override
    public Volunteer updateAvailability(Long volunteerId, boolean available) {
        Volunteer volunteer = volunteerRepository.findById(volunteerId)
                .orElseThrow(() -> new RuntimeException("Volunteer not found"));
        volunteer.setAvailabilityStatus(available);
        return volunteerRepository.save(volunteer);
    }
}
