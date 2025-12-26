package com.example.demo.service;

import com.example.demo.model.VolunteerSkill;
import java.util.List;

public interface VolunteerSkillService {
    VolunteerSkill addSkill(VolunteerSkill skill);
    VolunteerSkill updateSkill(VolunteerSkill skill);
    VolunteerSkill getSkillById(Long id);
    List<VolunteerSkill> getAllSkills();
    void deleteSkill(Long id);
}
