package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final Map<String, UserPrincipal> users = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Map<String, Object> registerUser(String fullName, String email, String password, String roleStr) {
        if (users.containsKey(email)) {
            throw new RuntimeException("User already exists with email: " + email);
        }

        UserRole role = UserRole.valueOf(roleStr);
        UserPrincipal user = new UserPrincipal(email, password, role);
        users.put(email, user);

        Map<String, Object> map = new HashMap<>();
        map.put("userId", idGenerator.getAndIncrement());
        map.put("role", roleStr);
        return map;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPrincipal user = users.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        return user;
    }
}
