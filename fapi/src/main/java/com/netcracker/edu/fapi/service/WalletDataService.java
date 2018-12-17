package com.netcracker.edu.fapi.service;
import com.netcracker.edu.fapi.entity.UpdateBalanceData;
import com.netcracker.edu.fapi.entity.WalletViewModel;
import java.util.List;

public interface WalletDataService {
    List<WalletViewModel> getAll();
    WalletViewModel getWalletById(Long id);
    WalletViewModel saveWallet(WalletViewModel wallet);
    void deleteWallet(Long id);
    void topUpBalance(UpdateBalanceData updateBalanceData);
    WalletViewModel getWalletByAccountId(Long accountId);
}
