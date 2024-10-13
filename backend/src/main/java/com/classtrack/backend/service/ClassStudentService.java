package com.classtrack.backend.service;
import com.classtrack.backend.entity.ClassEntity;
import com.classtrack.backend.entity.ClassStudent;
import com.classtrack.backend.repository.ClassStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class ClassStudentService {

    @Autowired
    private ClassStudentRepository classStudentRepository;

    public List<ClassStudent> getAllClassStudents() {
        return classStudentRepository.findAll();
    }

    public ClassStudent getClassStudentById(Long classStudentId) {
        return classStudentRepository.findById(classStudentId).orElse(null);
    }

    public ClassStudent saveClassStudent(ClassStudent classStudent) {
        //check both class and student entity's are available
        if (classStudent.getClassEntity() == null || classStudent.getStudent() == null) {
            throw new IllegalArgumentException("ClassEntity and Student must be set before saving ClassStudent");
        }

        // Check if the student is already registered in the class
        boolean exists = classStudentRepository.existsByClassEntityAndStudent(classStudent.getClassEntity(), classStudent.getStudent());
        if (exists) {
            throw new IllegalArgumentException("Student is already registered in this class");
        }

        // Generate the class-specific ID (csId)
        String csId = generateCsId(classStudent.getClassEntity());
        classStudent.setCsId(csId);

        return classStudentRepository.save(classStudent);
    }

    public void deleteClassStudent(Long classStudentId) {
        classStudentRepository.deleteById(classStudentId);
    }

    //Method to generate Class Specific Code for each student 000001 to M
//    private String generateCsId(ClassEntity classEntity) {
//        String classCode = classEntity.getCode();
//        String year = String.valueOf(java.time.Year.now().getValue()).substring(2);
//        ClassStudent lastClassStudent = classStudentRepository.findTopByClassEntityOrderByIdDesc(classEntity);
//        int nextNumber = 1;
//
//        if (lastClassStudent != null) {
//            // Extract the numeric part of the csId from the last student's csId
//            String lastCsId = lastClassStudent.getCsId();
//            String lastNumberPart = lastCsId.substring(lastCsId.length() - 6);
//            nextNumber = Integer.parseInt(lastNumberPart) + 1;
//        }
//
//        String numberPart = String.format("%06d", nextNumber);
//        return classCode + year + numberPart;
//    }
    private String generateCsId(ClassEntity classEntity) {
        String classCode = classEntity.getCode(); // Example: "MT"
        String year = String.valueOf(java.time.Year.now().getValue()).substring(2); // Last two digits of the current year
        Random random = new Random();
        String csId;

        // Generate unique csId for the class with no spaces in between
        do {
            int randomNumber = random.nextInt(999999) + 1; // Generates a random number between 1 and 999999
            String numberPart = String.format("%06d", randomNumber); // Format to 6 digits, e.g., "000001"
            csId = classCode + year + numberPart; // Concatenate classCode, year, and random number with no space
        } while (classStudentRepository.existsByClassEntityAndCsId(classEntity, csId)); // Ensure uniqueness within the class

        return csId;
    }
}
