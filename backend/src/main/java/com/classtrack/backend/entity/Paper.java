package com.classtrack.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "papers")
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String type;
    private String paperCode;

    @Temporal(TemporalType.DATE) // Ensure only the date is stored
    private Date date;


    @ManyToOne
    @JoinColumn(name = "class_id")
    private ClassEntity classEntity;
}
