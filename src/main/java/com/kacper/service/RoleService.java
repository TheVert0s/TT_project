package com.kacper.service;

import com.kacper.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    /*
        Operacje:
            przypisanie uprawnien do rol
     */
    void assignPermissionToRole(String permissionName, String roleName);

    List<Role> getRoles();
    Optional<Role> getRoleById(Long id);
}
