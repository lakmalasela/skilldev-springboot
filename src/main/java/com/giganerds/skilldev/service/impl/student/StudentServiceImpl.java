package com.giganerds.skilldev.service.impl.student;

import com.giganerds.skilldev.entity.StudentEntity;
import com.giganerds.skilldev.repository.StudentRepository;
import com.giganerds.skilldev.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository daostudent;

    @Override
    public StudentEntity createStudent(StudentEntity student) {
        return daostudent.save(student);
    }

    @Override
    public StudentEntity getStudentById(Long id) {
        return daostudent.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return daostudent.findAll();
    }

    @Override
    public StudentEntity updateStudent(Long id, StudentEntity studentDetails) {
        StudentEntity existingStudent = daostudent.findById(id).orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        existingStudent.setName(studentDetails.getName());
        existingStudent.setStudentcode(studentDetails.getStudentcode());
        return daostudent.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        StudentEntity student = getStudentById(id);
        daostudent.delete(student);
    }

    @Override
    public StudentEntity getStudentByStudentCode(String studentCode) {

        return daostudent.getStudentByStudentCode(studentCode);
    }


}
