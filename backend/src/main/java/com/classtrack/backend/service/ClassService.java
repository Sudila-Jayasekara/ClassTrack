package com.classtrack.backend.service;
import com.classtrack.backend.entity.ClassEntity;
import com.classtrack.backend.repository.ClassRepository;
import com.classtrack.backend.util.IdGenerator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor // Automatically generates a constructor with required arguments
public class ClassService {
    private final ClassRepository classRepository; // Using final with constructor injection


    public ClassEntity createClass(ClassEntity classEntity) {
        String classId;

        do {
            classId = IdGenerator.generateClassId();
        } while (classRepository.existsByClassId(classId));

        classEntity.setClassId(classId);
        return classRepository.save(classEntity);
    }


    // Method to get all classes
    public List<ClassEntity> getAllClasses() {
        return classRepository.findAll(); // Fetch all classes from the repository
    }
}
