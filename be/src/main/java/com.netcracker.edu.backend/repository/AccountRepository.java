package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends
        JpaRepository<Account, Long> {//с помощью CrudRep мы сможем вызывать различные методы
}