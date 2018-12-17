package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Account;
import com.netcracker.edu.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)//сопоставление запросов
    public ResponseEntity<Account> getAccountById(@PathVariable(name = "id") Long id){
        Optional<Account> account = accountService.getAccountById(id);
        if(account.isPresent()){
            return ResponseEntity.ok(account.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }//ответ

    @RequestMapping(value = "", method = RequestMethod.GET)//сопоставление запросов
    public Iterable<Account> getAllAccount(){
        return accountService.getAllAccount();
    }//ответ

    @RequestMapping(method = RequestMethod.POST)//сопоставление запросов
    public Account saveAccount(@RequestBody Account account){
        return this.accountService.saveAccount(account);
    }//ответ

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)//сопоставление запросов
    public ResponseEntity deleteAccountById(@PathVariable(name = "id") Long id){
        this.accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }//ответ

    @RequestMapping(value = "/page" , method = RequestMethod.GET)
    public Page<Account> getPage(@PageableDefault( sort = {"accountId"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return this.accountService.getAccountPage(pageable);
    }

}
