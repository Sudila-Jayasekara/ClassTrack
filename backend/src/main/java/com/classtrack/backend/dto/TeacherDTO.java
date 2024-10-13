package com.classtrack.backend.dto;

import com.classtrack.backend.entity.ClassEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    private List<ClassEntity> ClassEntity;
}
