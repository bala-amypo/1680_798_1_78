package com.example.demo.controller;

import com.example.demo.entity.Volunteer;
import com.example.demo.repository.VolunteerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteers")
public class VolunteerController {

    private final VolunteerRepository repository;

    public VolunteerController(VolunteerRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Volunteer save(@RequestBody Volunteer volunteer) {
        return repository.save(volunteer);
    }

    @GetMapping
    public List<Volunteer> getAll() {
        return repository.findAll();
    }
}
