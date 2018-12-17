package com.netcracker.edu.fapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletViewModel {

    private Long walletId;
    @CreditCardNumber
    @NotBlank
    private Long cardNumber;
    @Size(min = 3)
    @NotBlank
    private Integer CVV;
    @Size(min = 3)
    @NotBlank
    private String cardValidityPeriod;
    private Integer currency;
    private Long balance;
    @NotBlank
    private Long accountId;

    public WalletViewModel() {
    }

    public WalletViewModel(Long walletId, @CreditCardNumber @NotBlank Long cardNumber, @Size(min = 3)
    @NotBlank Integer CVV, @Size(min = 3)
    @NotBlank String cardValidityPeriod, Integer currency, Long balance, @NotBlank Long accountId) {
        this.walletId = walletId;
        this.cardNumber = cardNumber;
        this.CVV = CVV;
        this.cardValidityPeriod = cardValidityPeriod;
        this.currency = currency;
        this.balance = balance;
        this.accountId = accountId;
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCVV() {
        return CVV;
    }

    public void setCVV(Integer CVV) {
        this.CVV = CVV;
    }

    public String getCardValidityPeriod() {
        return cardValidityPeriod;
    }

    public void setCardValidityPeriod(String cardValidityPeriod) {
        this.cardValidityPeriod = cardValidityPeriod;
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
