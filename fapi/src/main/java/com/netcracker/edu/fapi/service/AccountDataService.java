package com.netcracker.edu.fapi.service;
import com.netcracker.edu.fapi.entity.AccountViewModel;

import java.util.List;

public interface AccountDataService {
    List<AccountViewModel> getAll();
    AccountViewModel getAccountById(Long id);
    AccountViewModel saveAccount(AccountViewModel account);
    void deleteAccount(Long id);
}
