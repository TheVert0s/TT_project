package com.kacper.service;

import com.kacper.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    /*
        Operacje:
            przypisanie rol do uzytkownika
     */
    void assignRoleToUser(String roleName, String userName);

    List<User> getUsers();
    Optional<User> getUserById(Long id);
}
