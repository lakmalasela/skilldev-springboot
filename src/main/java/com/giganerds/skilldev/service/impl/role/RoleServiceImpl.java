package com.giganerds.skilldev.service.impl.role;

import com.giganerds.skilldev.entity.role.RoleEntity;
import com.giganerds.skilldev.repository.role.RoleRepository;
import com.giganerds.skilldev.service.role.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleRepository daorole;

    @Override
    public List<RoleEntity> getAllRoles() {
        return daorole.findAll();
    }
}
