package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "wallet", schema = "backend")
public class Wallet {
    @Id
    @Column(name = "wallet_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long walletId;

    @Column(name = "card_number")
    private Long cardNumber;

    @Column(name = "CVV")
    private Integer CVV;

    @Column(name = "card_validity_period")
    private Date cardValidityPeriod;

    @Column(name = "currency")
    private Integer currency;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "account_id")
    private Long accountId;

    public Wallet() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(walletId, wallet.walletId) &&
                Objects.equals(cardNumber, wallet.cardNumber) &&
                Objects.equals(CVV, wallet.CVV) &&
                Objects.equals(cardValidityPeriod, wallet.cardValidityPeriod) &&
                Objects.equals(currency, wallet.currency) &&
                Objects.equals(balance, wallet.balance) &&
                Objects.equals(accountId, wallet.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(walletId, cardNumber, CVV, cardValidityPeriod, currency, balance, accountId);
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

    public Date getCardValidityPeriod() {
        return cardValidityPeriod;
    }

    public void setCardValidityPeriod(Date cardValidityPeriod) {
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
