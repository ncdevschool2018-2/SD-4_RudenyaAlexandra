package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.User;

import java.util.Optional;

public interface UsersService {

    User saveUser(User user);
    Optional<User> getUserById(Long id);
    Iterable<User> getAllUser();
    void deleteUser(Long id);

}
