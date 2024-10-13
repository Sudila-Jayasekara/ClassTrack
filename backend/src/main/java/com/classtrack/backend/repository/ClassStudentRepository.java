package com.classtrack.backend.repository;
import com.classtrack.backend.entity.ClassEntity;
import com.classtrack.backend.entity.ClassStudent;
import com.classtrack.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassStudentRepository extends JpaRepository<ClassStudent, Long> {
    boolean existsByClassEntityAndStudent(ClassEntity classEntity, Student student);
    boolean existsByClassEntityAndCsId(ClassEntity classEntity, String csId);
    //ClassStudent findTopByClassEntityOrderByIdDesc(ClassEntity classEntity);
}
