package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;

import java.util.List;
import java.util.Optional;

public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository repository;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public VolunteerProfile createVolunteer(VolunteerProfile profile) {

        if (repository.existsByVolunteerId(profile.getVolunteerId())) {
            throw new BadRequestException("Volunteer ID already exists");
        }
        if (repository.existsByEmail(profile.getEmail())) {
            throw new BadRequestException("Email already exists");
        }
        if (repository.existsByPhone(profile.getPhone())) {
            throw new BadRequestException("Phone already exists");
        }

        return repository.save(profile);
    }

    @Override
    public VolunteerProfile getVolunteerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Volunteer not found"));
    }

    @Override
    public List<VolunteerProfile> getAllVolunteers() {
        return repository.findAll();
    }

    @Override
    public Optional<VolunteerProfile> findByVolunteerId(String volunteerId) {
        return repository.findByVolunteerId(volunteerId);
    }
}




// package com.example.demo.service.impl;

// import com.example.demo.dto.AvailabilityUpdateRequest;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.exception.BadRequestException;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.VolunteerProfile;
// import com.example.demo.repository.VolunteerProfileRepository;
// import com.example.demo.service.VolunteerProfileService;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class VolunteerProfileServiceImpl implements VolunteerProfileService {

//     private final VolunteerProfileRepository repository;
//     private final PasswordEncoder passwordEncoder;

//     public VolunteerProfileServiceImpl(VolunteerProfileRepository repository,
//                                        PasswordEncoder passwordEncoder) {
//         this.repository = repository;
//         this.passwordEncoder = passwordEncoder;
//     }

//     @Override
//     public VolunteerProfile registerVolunteer(RegisterRequest request) {

//         if (repository.existsByEmail(request.getEmail())) {
//             throw new BadRequestException("email already exists");
//         }

//         VolunteerProfile volunteer = new VolunteerProfile();
//         volunteer.setFullName(request.getFullName());
//         volunteer.setEmail(request.getEmail());
//         volunteer.setPassword(passwordEncoder.encode(request.getPassword()));
//         volunteer.setRole(
//                 request.getRole() == null ? "VOLUNTEER" : request.getRole()
//         );
//         volunteer.setAvailabilityStatus("AVAILABLE");

//         return repository.save(volunteer);
//     }

//     @Override
//     public VolunteerProfile updateAvailability(Long volunteerId,
//                                                AvailabilityUpdateRequest request) {

//         VolunteerProfile volunteer = repository.findById(volunteerId)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Volunteer not found"));

//         volunteer.setAvailabilityStatus(request.getAvailabilityStatus());
//         return repository.save(volunteer);
//     }

//     @Override
//     public VolunteerProfile getVolunteer(Long id) {
//         return repository.findById(id)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Volunteer not found"));
//     }

//     @Override
//     public List<VolunteerProfile> getAllVolunteers() {
//         return repository.findAll();
//     }
// }
