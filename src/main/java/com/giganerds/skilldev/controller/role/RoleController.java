package com.giganerds.skilldev.controller.role;

import com.giganerds.skilldev.dto.ResponseMessage;
import com.giganerds.skilldev.entity.role.RoleEntity;
import com.giganerds.skilldev.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    public ResponseEntity<ResponseMessage<List<RoleEntity>>> getRoles() {
        List<RoleEntity> roles = roleService.getAllRoles();
        return ResponseEntity.ok(new ResponseMessage<>("Roles fetched successfully", roles));
    }

}
