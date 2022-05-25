package com.kacper.service;

import com.kacper.model.Permission;
import com.kacper.model.Role;
import com.kacper.model.User;
import com.kacper.repository.RoleRepository;
import com.kacper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void assignRoleToUser(String roleName, String userName) {
        Optional<Role> roleOpt = roleRepository.findByName(roleName);
        Optional<User> userOpt = userRepository.findByName(userName);

        User user;
        if(userOpt.isEmpty()) {
            user = new User(null, userName, new ArrayList<>());

            userRepository.save(user);

        } else {
            user = userOpt.get();
        }

        Role role;
        if(roleOpt.isEmpty()) {
            role = new Role(null, roleName, new ArrayList<>());

            roleRepository.save(role);

        } else {
            role = roleOpt.get();
        }

        user.getRoles().add(role);
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
