package com.giganerds.skilldev.controller.user;

import com.giganerds.skilldev.dto.ResponseMessage;
import com.giganerds.skilldev.dto.UserRequest;
import com.giganerds.skilldev.entity.user.UserEntity;
import com.giganerds.skilldev.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list")
    public ResponseEntity<ResponseMessage<Page<UserEntity>>> getUsers(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<UserEntity> users = userService.getUsers(search, page, size);
        return ResponseEntity.ok(new ResponseMessage<>("Users fetched successfully", users));
    }
}
