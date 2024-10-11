package com.classtrack.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String studentId; // Unique student ID

    @Column(nullable = false)
    private String studentName;

    private String studentAddress;
    private String studentPhone;
    private String studentEmail;

    @ManyToOne // Many students can belong to one class
    @JoinColumn(name = "class_id", nullable = false) // Foreign key column to ClassEntity
    private ClassEntity classEntity;

    @ManyToMany // Many students can take many papers
    @JoinTable(
            name = "student_paper", // Join table name
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "paper_id")
    )
    private List<Paper> papers; // List of papers this student is taking

    @OneToMany(mappedBy = "student") // One student can have many marks
    private List<Mark> marks; // Marks obtained by the student

}
