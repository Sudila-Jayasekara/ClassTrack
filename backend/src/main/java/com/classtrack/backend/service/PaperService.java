package com.classtrack.backend.service;
import com.classtrack.backend.entity.Paper;
import com.classtrack.backend.repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaperService {

    @Autowired
    private PaperRepository paperRepository;

    public List<Paper> getAllPapers() {
        return paperRepository.findAll();
    }

    public Paper getPaperById(Long paperId) {
        return paperRepository.findById(paperId).orElse(null);
    }

    public Paper savePaper(Paper paper) {
        return paperRepository.save(paper);
    }

    public void deletePaper(Long paperId) {
        paperRepository.deleteById(paperId);
    }
}
