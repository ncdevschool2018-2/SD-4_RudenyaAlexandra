package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUserById(Long id);
    Iterable<User> getAllUser();
    Optional<User> findByLogin(String login);
    void deleteUser(Long id);
    Page<User> getUserPage(Pageable pageable);
}
