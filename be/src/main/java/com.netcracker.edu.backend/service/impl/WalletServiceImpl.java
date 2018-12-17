package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.UpdateBalance;
import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.repository.WalletRepository;
import com.netcracker.edu.backend.service.WalletService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class WalletServiceImpl implements WalletService {

    private WalletRepository repository;

    @Autowired
    public WalletServiceImpl(WalletRepository repository) {
        this.repository = repository;
    }

    @Override
    public Wallet saveWallet(Wallet wallet) {
        return this.repository.save(wallet);
    }

    @Override
    public Optional<Wallet> getWalletById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Iterable<Wallet> getAllWallet() {
        return this.repository.findAll();
    }

    @Override
    public void deleteWallet(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public void topUpBalance(UpdateBalance updateBalance) {
        this.repository.topUpBalanceWallet(updateBalance.getId(), updateBalance.getAmount());
    }

    @Override
    public Optional<Wallet> getWalletByAccountId(Long accountId) {
        return this.repository.getWalletByAccountId(accountId);
    }
}
