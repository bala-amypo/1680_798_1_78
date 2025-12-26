package com.example.demo.service;

import com.example.demo.model.VolunteerSkillRecord;
import java.util.List;

public interface VolunteerSkillService {

    // Add or update a volunteer's skill
    VolunteerSkillRecord addOrUpdateSkill(VolunteerSkillRecord record);

    // Get all skills for a given volunteer
    List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId);
}
