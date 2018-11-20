package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUserById(Long id);
    Iterable<User> getAllUser();
    Optional<User> findByLogin(String login);
    void deleteUser(Long id);
}
