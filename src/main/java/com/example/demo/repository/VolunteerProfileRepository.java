package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.VolunteerProfile;
import java.util.*;

public interface VolunteerProfileRepository
        extends JpaRepository<VolunteerProfile, Long> {

    boolean existsByVolunteerId(String id);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
    List<VolunteerProfile> findByAvailabilityStatus(String status);
    Optional<VolunteerProfile> findByVolunteerId(String id);
}
