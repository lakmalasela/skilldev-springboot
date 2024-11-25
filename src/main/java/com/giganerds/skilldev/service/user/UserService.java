package com.giganerds.skilldev.service.user;

import java.util.Set;

public interface UserService {
    String registerUser(String username, String password, String email, Set<String> roleNames);
}
