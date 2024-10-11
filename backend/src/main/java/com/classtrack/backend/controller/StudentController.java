package com.classtrack.backend.controller;

import com.classtrack.backend.entity.Student;
import com.classtrack.backend.entity.Teacher;
import com.classtrack.backend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students") // Base URL for the teachers controller
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createTeacher(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }
}
