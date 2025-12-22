package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@Tag(name = "Volunteer Skills", description = "Manage volunteer skills")
public class VolunteerSkillController {

    private final VolunteerSkillService skillService;

    public VolunteerSkillController(VolunteerSkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    @Operation(summary = "Add or update a skill for a volunteer")
    public VolunteerSkillRecord addOrUpdateSkill(@RequestBody VolunteerSkillRecord skill) {
        return skillService.addOrUpdateSkill(skill);
    }

    @GetMapping("/volunteer/{volunteerId}")
    @Operation(summary = "Get skills for a volunteer")
    public List<VolunteerSkillRecord> getSkillsByVolunteer(@PathVariable Long volunteerId) {
        return skillService.getSkillsByVolunteer(volunteerId);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get skill by ID")
    public VolunteerSkillRecord getSkillById(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }

    @GetMapping
    @Operation(summary = "Get all skills")
    public List<VolunteerSkillRecord> getAllSkills() {
        return skillService.getAllSkills();
    }
}
