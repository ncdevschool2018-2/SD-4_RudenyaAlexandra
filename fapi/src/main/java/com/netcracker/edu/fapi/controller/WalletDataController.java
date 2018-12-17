package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.entity.UpdateBalanceData;
import com.netcracker.edu.fapi.entity.WalletViewModel;
import com.netcracker.edu.fapi.service.WalletDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallet")
public class WalletDataController {

    @Autowired
    private WalletDataService walletDataService;

    @RequestMapping
    public ResponseEntity<List<WalletViewModel>> getAllWallet() {

        return ResponseEntity.ok(walletDataService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<WalletViewModel> getWalletById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(walletDataService.getWalletById(id));
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<WalletViewModel> saveWallet(@RequestBody WalletViewModel wallet /*todo server validation*/) {
        if (wallet != null) {
            return ResponseEntity.ok(walletDataService.saveWallet(wallet));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteWallet(@PathVariable String id) {
        walletDataService.deleteWallet(Long.valueOf(id));
    }

    @RequestMapping(value = "/updateBalance/", method = RequestMethod.POST)
    public void updateBalanceWallet(@RequestBody UpdateBalanceData updateBalanceData) {
        this.walletDataService.topUpBalance(updateBalanceData);
    }

    @RequestMapping(value = "/get/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<WalletViewModel> getWalletByAccountId(@PathVariable(name = "accountId") Long accountId) {
        return ResponseEntity.ok(walletDataService.getWalletByAccountId(accountId));
    }

}
