package com.example.demo.controller;

import com.example.demo.model.Volunteer;
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
    public Volunteer save(@RequestBody Volunteer v) {
        return repository.save(v);
    }

    @GetMapping
    public List<Volunteer> findAll() {
        return repository.findAll();
    }
}
