package com.example.demo.util;

/**
 * Utility class for skill level comparison.
 * Used during volunteer-task matching.
 */
public final class SkillLevelUtil {

    private SkillLevelUtil() {
    }

    /**
     * Checks whether a volunteer skill level
     * is eligible for a required task skill level.
     *
     * @param volunteerLevel volunteer's skill level
     * @param requiredLevel task's required skill level
     * @return true if eligible, false otherwise
     */
    public static boolean isEligible(String volunteerLevel, String requiredLevel) {
        return getNumericLevel(volunteerLevel) >= getNumericLevel(requiredLevel);
    }

    /**
     * Converts skill level string to numeric value.
     *
     * Supported levels:
     * BEGINNER -> 1
     * INTERMEDIATE -> 2
     * ADVANCED -> 3
     */
    public static int getNumericLevel(String level) {
        if (level == null) {
            return 0;
        }

        switch (level.toUpperCase()) {
            case "BEGINNER":
                return 1;
            case "INTERMEDIATE":
                return 2;
            case "ADVANCED":
                return 3;
            default:
                return 0;
        }
    }
}
