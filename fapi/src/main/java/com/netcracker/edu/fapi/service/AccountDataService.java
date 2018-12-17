package com.netcracker.edu.fapi.service;
import com.netcracker.edu.fapi.entity.AccountViewModel;
import com.netcracker.edu.fapi.service.impl.RestPageImpl;
import org.springframework.data.domain.PageImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AccountDataService {
    List<AccountViewModel> getAll();
    AccountViewModel getAccountById(Long id);
    AccountViewModel saveAccount(AccountViewModel account);
    void deleteAccount(Long id);
    RestPageImpl<AccountViewModel> getAccountPage(HttpServletRequest request);
}
