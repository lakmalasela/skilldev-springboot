package com.giganerds.skilldev.service.user;

import com.giganerds.skilldev.entity.user.UserEntity;
import org.springframework.data.domain.Page;

import java.util.Set;

public interface UserService {
    String registerUser(String username, String password, String email, Set<String> roleNames);

    Page<UserEntity> getUsers(String search, int page, int size);
}
