package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.UpdateBalance;
import com.netcracker.edu.backend.entity.Wallet;

import java.util.Optional;

public interface WalletService {
    Wallet saveWallet(Wallet wallet);
    Optional<Wallet> getWalletById(Long id);
    Iterable<Wallet> getAllWallet();
    void deleteWallet(Long id);
    void topUpBalance(UpdateBalance balance);
    Optional<Wallet> getWalletByAccountId(Long accountId);
}
