package com.classtrack.backend.repository;

import com.classtrack.backend.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indicates that this interface is a Spring Data Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {
    boolean existsByTeacherId(String teacherId);
}
