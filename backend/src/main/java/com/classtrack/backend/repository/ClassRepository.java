package com.classtrack.backend.repository;

import com.classtrack.backend.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indicates that this interface is a Spring Data Repository
public interface ClassRepository extends JpaRepository<ClassEntity, String> {
    boolean existsByClassId(String classId); // Method to check if a class ID already exists
}
