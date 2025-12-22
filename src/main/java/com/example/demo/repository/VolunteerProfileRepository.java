package com.example.demo.repository;

import com.example.demo.model.VolunteerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VolunteerProfileRepository extends JpaRepository<VolunteerProfile, Long> {

    boolean existsByVolunteerId(String id);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    List<VolunteerProfile> findByAvailabilityStatus(String status);
    VolunteerProfile findByVolunteerId(String id);
}
