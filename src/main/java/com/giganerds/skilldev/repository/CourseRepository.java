package com.giganerds.skilldev.repository;

import com.giganerds.skilldev.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
}
