package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Account;
import com.netcracker.edu.backend.repository.AccountRepository;
import com.netcracker.edu.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountServiceImpl implements AccountService {


    private AccountRepository repository;

    @Autowired
    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account saveAccount(Account account) {

        return this.repository.save(account);
    }

    @Override
    public Optional<Account> getAccountById(Long id) {

        return this.repository.findById(id);
    }

    @Override
    public Iterable<Account> getAllAccount() {

        return this.repository.findAll();
    }

    @Override
    public void deleteAccount(Long id) {
        this.repository.deleteById(id);
    }
}
