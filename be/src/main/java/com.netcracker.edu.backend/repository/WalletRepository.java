package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface WalletRepository extends
        JpaRepository<Wallet, Long> {
    @Modifying
    @Transactional
    @Query("update Wallet w set w.balance = w.balance - :money where w.walletId = :walletId")
    void updateBalanceWallet(@Param("money") Integer money,
                             @Param("walletId")Long walletId);

    @Modifying
    @Transactional
    @Query("update Wallet w set w.balance = w.balance + :money where w.walletId = :walletId")
    void topUpBalanceWallet( @Param("walletId")Long walletId,
                             @Param("money") Integer money);

    @Query("select w from Wallet w where w.accountId = :accountId")
    Optional<Wallet> getWalletByAccountId(@Param("accountId")Long accountId);



}