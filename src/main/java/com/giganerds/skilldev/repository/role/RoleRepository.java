package com.giganerds.skilldev.repository.role;

import com.giganerds.skilldev.entity.role.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    RoleEntity findByName(String name);
}
