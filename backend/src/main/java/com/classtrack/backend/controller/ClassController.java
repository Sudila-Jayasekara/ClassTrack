package com.classtrack.backend.controller;
import com.classtrack.backend.entity.ClassEntity;
import com.classtrack.backend.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping
    public List<ClassEntity> getAllClasses() {
        return classService.getAllClasses();
    }

    @GetMapping("/{id}")
    public ClassEntity getClassById(@PathVariable Long id) {
        return classService.getClassById(id);
    }

    @PostMapping
    public ClassEntity createClass(@RequestBody ClassEntity classEntity) {
        return classService.saveClass(classEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
    }
}

