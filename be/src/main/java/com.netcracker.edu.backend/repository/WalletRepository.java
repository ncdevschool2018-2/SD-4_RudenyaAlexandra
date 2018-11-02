package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends
        CrudRepository<Wallet, Long> {//с помощью CrudRep мы сможем вызывать различные методы
}