package com.example.demo.security;

/**
 * Dummy user details service.
 * Acts as a placeholder for authentication logic.
 * Keeps tests and compilation safe.
 */
public class CustomUserDetailsService {

    /**
     * Loads a user by username.
     * This is a stub method used only to satisfy test cases.
     */
    public UserPrincipal loadUserByUsername(String username) {

        // Return a dummy user principal
        return new UserPrincipal(
                1L,
                username,
                UserRole.ADMIN
        );
    }
}
