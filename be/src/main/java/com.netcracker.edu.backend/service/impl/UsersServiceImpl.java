package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.repository.UserRepository;
import com.netcracker.edu.backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class UsersServiceImpl implements UsersService {

    private UserRepository repository;

    @Autowired
    public UsersServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User saveUser(User user) {
        return this.repository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Iterable<User> getAllUser() {
        return this.repository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        this.repository.deleteById(id);
    }
}
