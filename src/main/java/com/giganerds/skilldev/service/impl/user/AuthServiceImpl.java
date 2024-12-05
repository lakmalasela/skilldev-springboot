package com.giganerds.skilldev.service.impl.user;

import com.giganerds.skilldev.dto.LoginRequest;
import com.giganerds.skilldev.dto.ResponseMessage;
import com.giganerds.skilldev.entity.user.UserEntity;
import com.giganerds.skilldev.repository.user.UserRepository;
import com.giganerds.skilldev.service.user.AuthService;
import com.giganerds.skilldev.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public ResponseMessage<String> login(LoginRequest request) {
        UserEntity user = userRepository.findByUsername(request.getUsername());
        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }
        String token = jwtUtil.generateToken(user.getUsername());
        return new ResponseMessage<>("Login successful", token);
    }
}
