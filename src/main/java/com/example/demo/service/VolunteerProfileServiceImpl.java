package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;

import java.util.List;

public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository repository;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public VolunteerProfile createVolunteer(VolunteerProfile profile) {
        if (repository.existsByEmail(profile.getEmail())) {
            throw new BadRequestException("Email already exists");
        }
        if (repository.existsByVolunteerId(profile.getVolunteerId())) {
            throw new BadRequestException("VolunteerId already exists");
        }
        if (repository.existsByPhone(profile.getPhone())) {
            throw new BadRequestException("Phone already exists");
        }
        return repository.save(profile);
    }

    @Override
    public VolunteerProfile getVolunteerById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<VolunteerProfile> getAllVolunteers() {
        return repository.findAll();
    }

    @Override
    public VolunteerProfile findByVolunteerId(String volunteerId) {
        return repository.findByVolunteerId(volunteerId);
    }

    @Override
    public VolunteerProfile updateAvailability(Long id, String availabilityStatus) {
        VolunteerProfile v = repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Volunteer not found"));
        v.setAvailabilityStatus(availabilityStatus);
        return repository.save(v);
    }
}
