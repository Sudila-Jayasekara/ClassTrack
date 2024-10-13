package com.classtrack.backend.service;
import com.classtrack.backend.entity.Marks;
import com.classtrack.backend.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MarksService {

    @Autowired
    private MarksRepository marksRepository;

    public List<Marks> getAllMarks() {
        return marksRepository.findAll();
    }

    public Marks getMarksById(Long marksId) {
        return marksRepository.findById(marksId).orElse(null);
    }

    public Marks saveMarks(Marks marks) {
        return marksRepository.save(marks);
    }

    public void deleteMarks(Long marksId) {
        marksRepository.deleteById(marksId);
    }
}
