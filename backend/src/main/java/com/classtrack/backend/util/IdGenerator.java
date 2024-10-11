package com.classtrack.backend.util;

import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class IdGenerator {
    private static final List<String> restrictedCombinations = Arrays.asList(
            "BAD", "FOO", "XXX", "FUCK", "DAMN"
    );

    private static boolean containsRestrictedCombination(String classId) {
        for (String combination : restrictedCombinations) {
            if (classId.contains(combination)) {
                return true;
            }
        }
        return false;
    }

    public static String generateClassId() {
        Random random = new Random();
        String classId;

        do {
            StringBuilder classIdBuilder = new StringBuilder();
            String currentYear = String.valueOf(Year.now().getValue());
            classIdBuilder.append(currentYear);

            // Generate 4 random uppercase letters
            for (int i = 0; i < 4; i++) {
                char letter = (char) ('A' + random.nextInt(26));
                classIdBuilder.append(letter);
            }

            classId = classIdBuilder.toString();
        } while (containsRestrictedCombination(classId));

        return classId;
    }

    public static String generateTeacherId() {
        Random random = new Random();
        String teacherId;

        do {
            StringBuilder teacherIdBuilder = new StringBuilder();
            String currentYear = String.valueOf(Year.now().getValue());
            teacherIdBuilder.append(currentYear);

            // Generate 3 random uppercase letters
            for (int i = 0; i < 3; i++) {
                char letter = (char) ('A' + random.nextInt(26)); // Random uppercase letter A-Z
                teacherIdBuilder.append(letter);
            }

            // Generate 2 random digits
            for (int i = 0; i < 2; i++) {
                int digit = random.nextInt(10); // Random digit 0-9
                teacherIdBuilder.append(digit);
            }

            teacherId = teacherIdBuilder.toString();
        } while (containsRestrictedCombination(teacherId)); // Check for restricted combinations

        return teacherId; // Return generated ID
    }

}
