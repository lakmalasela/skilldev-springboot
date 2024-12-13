package com.giganerds.skilldev.controller.user;

import com.giganerds.skilldev.dto.LoginRequest;
import com.giganerds.skilldev.dto.ResponseMessage;
import com.giganerds.skilldev.service.user.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class LoginController {
    private final AuthService authService;


//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
//        // loginRequest will have username and password fields
//        return ResponseEntity.ok(authService.login(loginRequest.getUsername(), loginRequest.getPassword()));
//    }
    @PostMapping("/login")
    public ResponseEntity<ResponseMessage<String>> login( @Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

}
