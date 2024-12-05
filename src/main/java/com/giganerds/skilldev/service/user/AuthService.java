package com.giganerds.skilldev.service.user;

import com.giganerds.skilldev.dto.LoginRequest;
import com.giganerds.skilldev.dto.ResponseMessage;
import com.giganerds.skilldev.entity.user.UserEntity;

public interface AuthService {

//    String login(String username, String password);
ResponseMessage<String> login(LoginRequest request);
}
