package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Subscribe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SubscribeService {
    Subscribe saveSubscribe(Subscribe subscribe);
    Optional<Subscribe> getSubscribeById(Long id);
    Iterable<Subscribe> getAllSubscribe();
    void deleteSubscribe(Long id);
    Page<Subscribe> getSubscribePage(Pageable pageable);
}
