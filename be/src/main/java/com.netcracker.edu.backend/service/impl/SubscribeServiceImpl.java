package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Subscribe;
import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.repository.SubscribeRepository;
import com.netcracker.edu.backend.repository.UserRepository;
import com.netcracker.edu.backend.service.SubscribeService;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class SubscribeServiceImpl implements SubscribeService {

    private SubscribeRepository repository;

    @Autowired
    public SubscribeServiceImpl(SubscribeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subscribe saveSubscribe(Subscribe subscribe) {
        return this.repository.save(subscribe);
    }

    @Override
    public Optional<Subscribe> getSubscribeById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Iterable<Subscribe> getAllSubscribe() {
        return this.repository.findAll();
    }

    @Override
    public void deleteSubscribe(Long id) {
        this.repository.deleteById(id);
    }
}
