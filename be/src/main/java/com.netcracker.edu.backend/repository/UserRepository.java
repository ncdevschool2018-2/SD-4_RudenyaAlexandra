package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends
    CrudRepository<User, Long>{//с помощью CrudRep мы сможем вызывать различные методы
}