package com.netcracker.edu.fapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletViewModel {
    private Long wallet_id;
    private Long card_number;
    private Integer CVV;
    private String card_validity_period;
    private Integer currency;
    private Long balance;
    private AccountViewModel account_id;

    public WalletViewModel() {
    }

    public Long getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(Long wallet_id) {
        this.wallet_id = wallet_id;
    }

    public Long getCard_number() {
        return card_number;
    }

    public void setCard_number(Long card_number) {
        this.card_number = card_number;
    }

    public Integer getCVV() {
        return CVV;
    }

    public void setCVV(Integer CVV) {
        this.CVV = CVV;
    }

    public String getCard_validity_period() {
        return card_validity_period;
    }

    public void setCard_validity_period(String card_validity_period) {
        this.card_validity_period = card_validity_period;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public AccountViewModel getAccount_id() {
        return account_id;
    }

    public void setAccount_id(AccountViewModel account_id) {
        this.account_id = account_id;
    }
}
