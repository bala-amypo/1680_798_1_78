package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/volunteer/skills")
public class VolunteerSkillController {

    private final VolunteerSkillService service;

    @Autowired
    public VolunteerSkillController(VolunteerSkillService service) {
        this.service = service;
    }

    @PostMapping
    public VolunteerSkillRecord addOrUpdateSkill(@RequestBody VolunteerSkillRecord record) {
        return service.addOrUpdateSkill(record);
    }

    @GetMapping("/{volunteerId}")
    public List<VolunteerSkillRecord> getSkillsByVolunteer(@PathVariable Long volunteerId) {
        return service.getSkillsByVolunteer(volunteerId);
    }
}
