package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.AuthService;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final VolunteerProfileService volunteerProfileService;

    public AuthController(AuthService authService,
                          VolunteerProfileService volunteerProfileService) {
        this.authService = authService;
        this.volunteerProfileService = volunteerProfileService;
    }

    @PostMapping("/register")
    public ResponseEntity<VolunteerProfile> register(
            @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(
                volunteerProfileService.registerVolunteer(request)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody AuthRequest request) {
        return ResponseEntity.ok(
                authService.authenticate(request)
        );
    }
}
