package com.classtrack.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "class_students")
public class ClassStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String csId; //auto generate class code + year + random number

    @ManyToOne
    private ClassEntity classEntity;

    @ManyToOne
    private Student student;
    // getters and setters
}
