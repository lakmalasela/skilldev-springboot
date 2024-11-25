package com.giganerds.skilldev.controller.user;

import com.giganerds.skilldev.dto.ResponseMessage;
import com.giganerds.skilldev.dto.UserRequest;
import com.giganerds.skilldev.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

@Autowired
private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseMessage<String>> registerUser(@Valid @RequestBody UserRequest request) {
        try {
//            userService.registerUser(
//                    request.getUsername(),
//                    request.getPassword(),
//                    request.getEmail(),
//                    request.getRoles()
//            );
            String user = userService.registerUser(
                    request.getUsername(),
                    request.getPassword(),
                    request.getEmail(),
                    request.getRoles()
            );
            return ResponseEntity.ok(new ResponseMessage<>("User registered successfully", user));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ResponseMessage<>(e.getMessage(), null));
        }
    }
}
