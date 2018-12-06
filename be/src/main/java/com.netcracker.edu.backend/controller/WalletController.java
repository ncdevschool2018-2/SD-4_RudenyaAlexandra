package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.service.WalletService;
import com.netcracker.edu.backend.service.impl.ChargeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    private WalletService  walletService;

    @Autowired
    private ChargeServiceImpl chargeService;

    @Autowired
    public WalletController(WalletService  walletService){
        this.walletService =  walletService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)//сопоставление запросов
    public ResponseEntity<Wallet> getWalletById(@PathVariable(name = "id") Long id){
        Optional<Wallet> wallet = walletService.getWalletById(id);
        if(wallet.isPresent()){
            return ResponseEntity.ok(wallet.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }//ответ

    @RequestMapping(value = "", method = RequestMethod.GET)//сопоставление запросов
    public Iterable<Wallet> getAllWallet(){
        return walletService.getAllWallet();
    }//ответ

    @RequestMapping(method = RequestMethod.POST)//сопоставление запросов
    public Wallet saveWallet(@RequestBody Wallet wallet){
        return this.walletService.saveWallet(wallet);
    }//ответ

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)//сопоставление запросов
    public ResponseEntity deleteWalletById(@PathVariable(name = "id") Long id){
        this.walletService.deleteWallet(id);
        return ResponseEntity.noContent().build();
    }//ответ
}
