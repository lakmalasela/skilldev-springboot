package com.giganerds.skilldev.repository;

import com.giganerds.skilldev.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
}
