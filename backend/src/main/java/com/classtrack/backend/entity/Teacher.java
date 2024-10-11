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
    @Table(name = "teachers")
    public class Teacher {
        @Id
        @Column(nullable = false, unique = true)
        private String teacherId;

        @Column(unique = true , nullable = false)
        private String teacherEmail;

        @Column(nullable = false)
        private String teacherPassword;

        @Column(nullable = false)
        private String teacherName;

        private String teacherAddress;
        private String teacherPhone;


        @JsonIgnore
        @OneToMany(mappedBy = "teacher") // One teacher can have many classes
        private List<ClassEntity> classes; // List of ClassEntity objects associated with this teacher
    }
