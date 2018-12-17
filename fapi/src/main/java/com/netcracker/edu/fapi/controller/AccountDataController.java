package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.entity.AccountViewModel;
import com.netcracker.edu.fapi.service.AccountDataService;
import com.netcracker.edu.fapi.service.impl.RestPageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountDataController {

    @Autowired
    private AccountDataService accountDataService;

    @RequestMapping
    public ResponseEntity<List<AccountViewModel>> getAllAccount() {

        return ResponseEntity.ok(accountDataService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AccountViewModel> getAccountById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(accountDataService.getAccountById(id));
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AccountViewModel> saveAccount(@RequestBody AccountViewModel account /*todo server validation*/) {
        if (account != null) {
            return ResponseEntity.ok(accountDataService.saveAccount(account));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable String id) {
        accountDataService.deleteAccount(Long.valueOf(id));
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<RestPageImpl<AccountViewModel>> getUserPage(HttpServletRequest request) {
        return ResponseEntity.ok(accountDataService.getAccountPage(request));
    }

}
