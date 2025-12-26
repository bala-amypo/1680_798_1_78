package com.example.demo.service.impl;

import com.example.demo.model.VolunteerSkill;
import com.example.demo.repository.VolunteerSkillRepository;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerSkillServiceImpl implements VolunteerSkillService {

    @Autowired
    private VolunteerSkillRepository skillRepository;

    @Override
    public VolunteerSkill addSkill(VolunteerSkill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public VolunteerSkill updateSkill(VolunteerSkill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public VolunteerSkill getSkillById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public List<VolunteerSkill> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
}
