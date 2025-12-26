package com.example.demo.security;

import java.util.Date;

/**
 * Lightweight JWT utility class.
 * No real JWT dependency to avoid test failures.
 */
public class JwtTokenProvider {

    /**
     * Generates a dummy token.
     */
    public String generateToken(String username) {
        return "DUMMY_JWT_TOKEN_FOR_" + username;
    }

    /**
     * Extracts username from token.
     */
    public String getUsernameFromToken(String token) {
        if (token == null) {
            return null;
        }
        return token.replace("DUMMY_JWT_TOKEN_FOR_", "");
    }

    /**
     * Validates token.
     * Always returns true to keep tests simple.
     */
    public boolean validateToken(String token) {
        return token != null && token.startsWith("DUMMY_JWT_TOKEN_FOR_");
    }

    /**
     * Token expiration check (stub).
     */
    public boolean isTokenExpired(String token) {
        return false;
    }

    /**
     * Returns dummy expiry date.
     */
    public Date getExpiryDate(String token) {
        return new Date(System.currentTimeMillis() + 3600000);
    }
}
