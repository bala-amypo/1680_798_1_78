package com.example.demo.controller;

import com.example.demo.entity.Volunteer;
import com.example.demo.repository.VolunteerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {

    private final VolunteerRepository repository;

    public VolunteerController(VolunteerRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Volunteer create(@RequestBody Volunteer volunteer) {
        return repository.save(volunteer);
    }

    @GetMapping
    public List<Volunteer> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Volunteer getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Volunteer update(@PathVariable Long id, @RequestBody Volunteer volunteer) {
        Volunteer existing = repository.findById(id).orElseThrow();
        existing.setName(volunteer.getName());
        existing.setEmail(volunteer.getEmail());
        existing.setPhone(volunteer.getPhone());
        return repository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
