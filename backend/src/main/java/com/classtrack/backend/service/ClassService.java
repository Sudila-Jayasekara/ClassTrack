package com.classtrack.backend.service;
import com.classtrack.backend.entity.ClassEntity;
import com.classtrack.backend.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public List<ClassEntity> getAllClasses() {
        return classRepository.findAll();
    }

    public ClassEntity getClassById(Long classId) {
        return classRepository.findById(classId).orElse(null);
    }

    public ClassEntity saveClass(ClassEntity classEntity) {
        return classRepository.save(classEntity);
    }

    public void deleteClass(Long classId) {
        classRepository.deleteById(classId);
    }
}
