package com.classtrack.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "papers")
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String paperType;

    @ManyToMany(mappedBy = "papers")
    private List<Student> students;

    @OneToMany(mappedBy = "paper") // One paper can have multiple marks
    private List<Mark> marks; // Marks for this paper
}
