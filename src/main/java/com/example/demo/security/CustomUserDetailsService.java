package com.example.demo.security;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final VolunteerProfileRepository volunteerProfileRepository;

    public CustomUserDetailsService(
            VolunteerProfileRepository volunteerProfileRepository) {
        this.volunteerProfileRepository = volunteerProfileRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        VolunteerProfile volunteer = volunteerProfileRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email: " + email));

        return new User(
                volunteer.getEmail(),
                volunteer.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + volunteer.getRole()))
        );
    }
}
