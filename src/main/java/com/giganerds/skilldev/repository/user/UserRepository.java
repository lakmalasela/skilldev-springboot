package com.giganerds.skilldev.repository.user;

import com.giganerds.skilldev.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
}
