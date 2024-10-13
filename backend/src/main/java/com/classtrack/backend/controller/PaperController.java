package com.classtrack.backend.controller;
import com.classtrack.backend.entity.Paper;
import com.classtrack.backend.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/papers")
public class PaperController {

    @Autowired
    private PaperService paperService;

    @GetMapping
    public List<Paper> getAllPapers() {
        return paperService.getAllPapers();
    }

    @GetMapping("/{id}")
    public Paper getPaperById(@PathVariable Long id) {
        return paperService.getPaperById(id);
    }

    @PostMapping
    public Paper createPaper(@RequestBody Paper paper) {
        return paperService.savePaper(paper);
    }

    @DeleteMapping("/{id}")
    public void deletePaper(@PathVariable Long id) {
        paperService.deletePaper(id);
    }
}
