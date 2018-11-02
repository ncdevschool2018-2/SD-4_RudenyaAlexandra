package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Subscribe;

import java.util.Optional;

public interface SubscribeService {
    Subscribe saveSubscribe(Subscribe subscribe);
    Optional<Subscribe> getSubscribeById(Long id);
    Iterable<Subscribe> getAllSubscribe();
    void deleteSubscribe(Long id);
}
