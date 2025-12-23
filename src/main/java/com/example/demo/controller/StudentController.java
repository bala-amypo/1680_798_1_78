package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @Operation(summary = "Create student")
    @PostMapping
    public Student create(@RequestBody Student student) {
        return repository.save(student);
    }

    @Operation(summary = "Get all students")
    @GetMapping
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Operation(summary = "Get student by id")
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @Operation(summary = "Update student")
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return repository.save(student);
    }

    @Operation(summary = "Delete student")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
