package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Product;
import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.repository.UserRepository;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;

@Component(value = "userService")
public class UserServiceImpl implements UserService{

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {

        this.repository = repository;
    }

    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User user) {
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
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
    public Optional<User> findByLogin(String login) {

        return this.repository.findByLogin(login);
    }

    @Override
    public void deleteUser(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Page<User> getUserPage(Pageable pageable) {
        return this.repository.findAll(pageable);
    }
}
