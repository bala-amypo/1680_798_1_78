package com.example.demo.service.impl;

import com.example.demo.model.Volunteer;
import com.example.demo.repository.VolunteerRepository;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    @Autowired
    private VolunteerRepository volunteerRepository;

    @Override
    public Volunteer createVolunteer(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

    @Override
    public Volunteer updateVolunteer(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

    @Override
    public Volunteer getVolunteerById(Long id) {
        return volunteerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    @Override
    public void deleteVolunteer(Long id) {
        volunteerRepository.deleteById(id);
    }
}
