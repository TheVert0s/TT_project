package com.kacper.controller;

import com.kacper.dto.RoleUserDto;
import com.kacper.model.User;
import com.kacper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/assign_role_to_user")
    public void assignRoleToUser(@RequestBody RoleUserDto dto) {
        userService.assignRoleToUser(dto.roleName, dto.userName);
    }
}
