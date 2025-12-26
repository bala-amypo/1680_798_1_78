package com.example.demo.service.impl;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class VolunteerSkillServiceImpl implements VolunteerSkillService {

    @Autowired
    private VolunteerSkillRecordRepository repository;

    @Override
    public VolunteerSkillRecord addOrUpdateSkill(VolunteerSkillRecord record) {
        return repository.save(record);
    }

    @Override
    public List<VolunteerSkillRecord> getSkillsByVolunteer(Long volunteerId) {
        return repository.findByVolunteerId(volunteerId);
    }
}
