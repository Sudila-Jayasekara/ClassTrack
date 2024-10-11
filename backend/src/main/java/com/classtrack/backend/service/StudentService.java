package com.classtrack.backend.service;

import com.classtrack.backend.entity.Student;
import com.classtrack.backend.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    // Utility method to generate a Student ID in the format XXX
    private String generateStudentId() {
        StringBuilder classId = new StringBuilder();
        Random random = new Random();

        // Generate 2 random uppercase letters
        for (int i = 0; i < 2; i++) {
            char letter = (char) ('A' + random.nextInt(26)); // Random uppercase letter A-Z
            classId.append(letter);
        }

        // Generate 3 random digits
        for (int i = 0; i < 2; i++) {
            int digit = random.nextInt(10); // Random digit 0-9
            classId.append(digit);
        }

        return classId.toString(); // Return generated ID
    }

    //Create new student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

}
