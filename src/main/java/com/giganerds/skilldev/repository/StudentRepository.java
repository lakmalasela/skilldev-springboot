package com.giganerds.skilldev.repository;

import com.giganerds.skilldev.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    @Query(value = "SELECT * FROM skilldev.student s WHERE s.studentcode = ?1", nativeQuery = true)
    StudentEntity getStudentByStudentCode(String studentCode);
}
