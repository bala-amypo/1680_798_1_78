package com.example.demo.repository;

import com.example.demo.model.VolunteerProfile;

import java.util.List;
import java.util.Optional;

public interface VolunteerProfileRepository {

    boolean existsByVolunteerId(String volunteerId);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    VolunteerProfile save(VolunteerProfile profile);

    Optional<VolunteerProfile> findById(Long id);

    Optional<VolunteerProfile> findByVolunteerId(String volunteerId);

    List<VolunteerProfile> findAll();

    List<VolunteerProfile> findByAvailabilityStatus(String availabilityStatus);
}


























// package com.example.demo.repository;

// import com.example.demo.model.VolunteerProfile;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.List;
// import java.util.Optional;

// public interface VolunteerProfileRepository extends JpaRepository<VolunteerProfile, Long> {

//     boolean existsByEmail(String email);

//     Optional<VolunteerProfile> findByEmail(String email);

//     List<VolunteerProfile> findByAvailabilityStatus(String availabilityStatus);
// }
