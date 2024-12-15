package com.giganerds.skilldev.service.impl.user;

import com.giganerds.skilldev.entity.role.RoleEntity;
import com.giganerds.skilldev.entity.user.UserEntity;
import com.giganerds.skilldev.repository.role.RoleRepository;
import com.giganerds.skilldev.repository.user.UserRepository;
import com.giganerds.skilldev.service.user.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository daouser;
    private RoleRepository daorole;


    private final PasswordEncoder passwordEncoder;

    @Override
    public String registerUser(String username, String password, String email, Set<String> roleNames) {
        if (daouser.findByUsername(username) != null) {
            throw new IllegalArgumentException("Username already exists");
        }

        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);

        // Map role names to Role entities
        Set<RoleEntity> roles = roleNames.stream()
                .map(daorole::findByName)
                .filter(role -> role != null)
                .collect(Collectors.toSet());

        if (roles.isEmpty()) {
            throw new IllegalArgumentException("At least one valid role is required");
        }

        user.setRoles(roles);

        daouser.save(user);
        return user.getUsername();
    }

    @Override
    public Page<UserEntity> getUsers(String search, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return daouser.findByUsernameContainingIgnoreCaseOrEmailContainingIgnoreCase(search, search, pageable);
    }

}
