package com.kacper.service;

import com.kacper.model.Permission;
import com.kacper.model.Role;
import com.kacper.repository.PermissionRepository;
import com.kacper.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, PermissionRepository permissionRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public void assignPermissionToRole(String permissionName, String roleName) {
        Optional<Permission> permissionOpt = permissionRepository.findByName(permissionName);
        Optional<Role> roleOpt = roleRepository.findByName(roleName);

        Role role;
        if(roleOpt.isEmpty()) {
            role = new Role(null, roleName, new ArrayList<>());

            roleRepository.save(role);

        } else {
            role = roleOpt.get();
        }

        Permission permission;
        if(permissionOpt.isEmpty()) {
            permission = new Permission(null, permissionName);

            permissionRepository.save(permission);

        } else {
            permission = permissionOpt.get();
        }

        role.getPermissions().add(permission);
        roleRepository.save(role);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }
}
