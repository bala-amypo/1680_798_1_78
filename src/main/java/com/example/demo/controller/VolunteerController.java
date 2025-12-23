package com.example.demo.controller;

import com.example.demo.dto.AvailabilityUpdateRequest;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {

    private final VolunteerProfileService volunteerProfileService;

    public VolunteerController(VolunteerProfileService volunteerProfileService) {
        this.volunteerProfileService = volunteerProfileService;
    }

    @GetMapping
    public ResponseEntity<List<VolunteerProfile>> getAllVolunteers() {
        return ResponseEntity.ok(
                volunteerProfileService.getAllVolunteers()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<VolunteerProfile> getVolunteer(@PathVariable Long id) {
        return ResponseEntity.ok(
                volunteerProfileService.getVolunteer(id)
        );
    }

    @PutMapping("/{id}/availability")
    public ResponseEntity<VolunteerProfile> updateAvailability(
            @PathVariable Long id,
            @RequestBody AvailabilityUpdateRequest request) {
        return ResponseEntity.ok(
                volunteerProfileService.updateAvailability(id, request)
        );
    }
}

