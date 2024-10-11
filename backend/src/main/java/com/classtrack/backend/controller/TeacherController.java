package com.classtrack.backend.controller;

import com.classtrack.backend.entity.ClassEntity;
import com.classtrack.backend.entity.Teacher;
import com.classtrack.backend.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers") // Base URL for the teachers controller
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        return ResponseEntity.ok(teacherService.createTeacher(teacher));
    }

    // Get all classes by teacher ID
    @GetMapping("/{id}/classes")
    public ResponseEntity<List<ClassEntity>> getClassesByTeacherId(@PathVariable String id) {
        List<ClassEntity> classes = teacherService.getClassesByTeacherId(id);
        return ResponseEntity.ok(classes);
    }
}
