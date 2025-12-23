package com.example.demo.util;

public final class SkillLevelUtil {

    private SkillLevelUtil() {
        // utility class – prevent instantiation
    }

    /**
     * Checks whether a volunteer's skill level meets or exceeds
     * the required level for a task.
     *
     * @param volunteerLevel volunteer's skill level
     * @param requiredLevel task's required skill level
     * @return true if volunteerLevel >= requiredLevel
     */
    public static boolean meetsRequiredLevel(
            Integer volunteerLevel,
            Integer requiredLevel) {

        if (volunteerLevel == null || requiredLevel == null) {
            return false;
        }

        return volunteerLevel >= requiredLevel;
    }
}
