package com.classtrack.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "marks")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int score;

    @ManyToOne // Many Marks can belong to one student
    @JoinColumn(name = "student_id", nullable = false) // Foreign key column
    private Student student; // Reference to Student object

    @ManyToOne
    @JoinColumn(name = "paper_id",nullable = false)
    private Paper paper;
}
