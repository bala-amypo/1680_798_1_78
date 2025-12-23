package com.example.demo.repository;

import com.example.demo.model.VolunteerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VolunteerProfileRepository extends JpaRepository<VolunteerProfile, Long> {

    boolean existsByEmail(String email);

    Optional<VolunteerProfile> findByEmail(String email);

    List<VolunteerProfile> findByAvailabilityStatus(String availabilityStatus);
}
