package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Subscribe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscribeRepository extends
        CrudRepository<Subscribe, Long> {//с помощью CrudRep мы сможем вызывать различные методы
}