package com.giganerds.skilldev.service.student;

import com.giganerds.skilldev.entity.StudentEntity;

import java.util.List;

public interface StudentService {

    StudentEntity createStudent(StudentEntity student); // Create a student
    StudentEntity getStudentById(Long id); // Get a student by ID
    List<StudentEntity> getAllStudents(); // Get all students
    StudentEntity updateStudent(Long id, StudentEntity student); // Update a student
    void deleteStudent(Long id); // Delete a student

    StudentEntity getStudentByStudentCode(String studentCode);
}
