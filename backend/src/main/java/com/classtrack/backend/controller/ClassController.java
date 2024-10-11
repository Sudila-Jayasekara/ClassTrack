package com.classtrack.backend.controller;

import com.classtrack.backend.entity.ClassEntity;
import com.classtrack.backend.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes") // Base URL for the class controller
@RequiredArgsConstructor
public class ClassController {
    private final ClassService classService;

    @PostMapping
    public ResponseEntity<ClassEntity> createClass(@RequestBody ClassEntity classEntity) {
        ClassEntity createdClass = classService.createClass(classEntity);
        return ResponseEntity.ok(createdClass);
    }

    @GetMapping // Endpoint to get all classes
    public ResponseEntity<List<ClassEntity>> getAllClasses() {
        List<ClassEntity> classes = classService.getAllClasses();
        return ResponseEntity.ok(classes);
    }

    // Add more endpoints as needed (e.g., get class by ID, delete class)
}