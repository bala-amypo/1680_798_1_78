package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
@Tag(name = "Volunteer Profiles", description = "Operations for volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService volunteerService;

    public VolunteerProfileController(VolunteerProfileService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @PostMapping
    @Operation(summary = "Create a new volunteer")
    public VolunteerProfile createVolunteer(@RequestBody VolunteerProfile profile) {
        return volunteerService.createVolunteer(profile);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get volunteer by ID")
    public VolunteerProfile getVolunteer(@PathVariable Long id) {
        return volunteerService.getVolunteerById(id);
    }

    @GetMapping
    @Operation(summary = "Get all volunteers")
    public List<VolunteerProfile> getAllVolunteers() {
        return volunteerService.getAllVolunteers();
    }

    @PutMapping("/{id}/availability")
    @Operation(summary = "Update volunteer availability")
    public VolunteerProfile updateAvailability(@PathVariable Long id, @RequestParam String status) {
        return volunteerService.updateAvailability(id, status);
    }

    @GetMapping("/lookup/{volunteerId}")
    @Operation(summary = "Lookup volunteer by volunteerId")
    public VolunteerProfile findByVolunteerId(@PathVariable String volunteerId) {
        return volunteerService.findByVolunteerId(volunteerId);
    }
}
