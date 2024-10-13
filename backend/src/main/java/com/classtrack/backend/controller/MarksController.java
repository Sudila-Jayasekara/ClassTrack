package com.classtrack.backend.controller;
import com.classtrack.backend.entity.Marks;
import com.classtrack.backend.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
public class MarksController {

    @Autowired
    private MarksService marksService;

    @GetMapping
    public List<Marks> getAllMarks() {
        return marksService.getAllMarks();
    }

    @GetMapping("/{id}")
    public Marks getMarksById(@PathVariable Long id) {
        return marksService.getMarksById(id);
    }

    @PostMapping
    public Marks createMarks(@RequestBody Marks marks) {
        return marksService.saveMarks(marks);
    }

    @DeleteMapping("/{id}")
    public void deleteMarks(@PathVariable Long id) {
        marksService.deleteMarks(id);
    }
}
