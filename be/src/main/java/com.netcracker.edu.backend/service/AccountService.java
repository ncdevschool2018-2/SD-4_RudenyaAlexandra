package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AccountService {
    Account saveAccount(Account account);
    Optional<Account> getAccountById(Long id);
    Iterable<Account> getAllAccount();
    void deleteAccount(Long id);
    Page<Account> getAccountPage(Pageable pageable);
}
