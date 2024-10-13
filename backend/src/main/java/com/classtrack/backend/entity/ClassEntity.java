package com.classtrack.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "classes")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code; //teacher's preference code like MT(All caps)
    private String name;
    private String subject; //because same teacher can teach more than one subject
    private String academicYear;


    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


    @OneToMany(mappedBy = "classEntity")
    private List<Paper> papers;

    //validation
    //check code is all caps , if not convert to capital
    public void setCode(String code) {
        this.code = code != null ? code.toUpperCase() : null;
    }
}
