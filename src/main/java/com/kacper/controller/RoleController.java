package com.kacper.controller;

import com.kacper.dto.PermissionRoleDto;
import com.kacper.dto.RoleUserDto;
import com.kacper.model.Role;
import com.kacper.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/role")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    @GetMapping("/role/{id}")
    public Optional<Role> getRoleById(@PathVariable("id") Long id) {
        return roleService.getRoleById(id);
    }

    @PostMapping("/assign_permission_to_role")
    public void assignPermissionToRole(@RequestBody PermissionRoleDto dto) {
        roleService.assignPermissionToRole(dto.permission, dto.role);
    }
}
