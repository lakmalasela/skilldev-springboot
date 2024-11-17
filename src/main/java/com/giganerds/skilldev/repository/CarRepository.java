package com.giganerds.skilldev.repository;

import com.giganerds.skilldev.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity,Long> {
}
