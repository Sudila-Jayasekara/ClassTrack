package com.classtrack.backend.service;

import com.classtrack.backend.entity.ClassEntity;
import com.classtrack.backend.entity.Teacher;
import com.classtrack.backend.repository.TeacherRepository;
import com.classtrack.backend.util.IdGenerator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    //Method to create a new teacher
    public Teacher createTeacher(Teacher teacher) {
        String teacherId;
        do {
            teacherId = IdGenerator.generateClassId();
        } while (teacherRepository.existsByTeacherId(teacherId));

        teacher.setTeacherId(teacherId);
        return teacherRepository.save(teacher);
    }


    //Method to get all teachers
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // Method to get all classes by teacher's ID
    public List<ClassEntity> getClassesByTeacherId(String teacherId) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
        if (optionalTeacher.isPresent()) {
            return optionalTeacher.get().getClasses(); // Return the list of classes for the found teacher
        }
        return List.of(); // Return an empty list if the teacher is not found
    }
}
