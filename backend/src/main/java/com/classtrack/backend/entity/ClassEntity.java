package com.classtrack.backend.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classes")
public class ClassEntity {
    @Id
    @Column(nullable = false, unique = true)
    private String classId; // The generated class ID

    @Column(nullable = false)
    private int year; // Academic year

    @Column(nullable = false)
    private int grade; // Grade level

    @Column(nullable = false)
    private String subject;  // Subject taught by the teacher


    private String institute; // Name of the Institute

    @ManyToOne // Many classes can belong to one teacher
    @JoinColumn(name = "teacher_id", nullable = false) // Foreign key column
    private Teacher teacher; // Reference to the Teacher object

    @OneToMany(mappedBy = "classEntity")
    private List<Student> students;
}

