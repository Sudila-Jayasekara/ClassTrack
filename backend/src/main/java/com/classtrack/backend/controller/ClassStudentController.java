package com.classtrack.backend.controller;
import com.classtrack.backend.entity.ClassStudent;
import com.classtrack.backend.service.ClassStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class-students")
public class ClassStudentController {

    @Autowired
    private ClassStudentService classStudentService;

    @GetMapping
    public List<ClassStudent> getAllClassStudents() {
        return classStudentService.getAllClassStudents();
    }

    @GetMapping("/{id}")
    public ClassStudent getClassStudentById(@PathVariable Long id) {
        return classStudentService.getClassStudentById(id);
    }

    @PostMapping
    public ClassStudent createClassStudent(@RequestBody ClassStudent classStudent) {
        return classStudentService.saveClassStudent(classStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteClassStudent(@PathVariable Long id) {
        classStudentService.deleteClassStudent(id);
    }
}
