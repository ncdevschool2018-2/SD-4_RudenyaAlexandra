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
    private Long wallet_id;

    @Column(name = "card_number")
    private Long card_number;

    @Column(name = "CVV")
    private Integer CVV;

    @Column(name = "card_validity_period")
    private String card_validity_period;

    @Column(name = "currency")
    private Integer currency;

    @Column(name = "balance")
    private Long balance;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(wallet_id, wallet.wallet_id) &&
                Objects.equals(card_number, wallet.card_number) &&
                Objects.equals(CVV, wallet.CVV) &&
                Objects.equals(card_validity_period, wallet.card_validity_period) &&
                Objects.equals(currency, wallet.currency) &&
                Objects.equals(balance, wallet.balance) &&
                Objects.equals(account_id, wallet.account_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wallet_id, card_number, CVV, card_validity_period, currency, balance, account_id);
    }

    public Wallet() {
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

    public Account getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Account account_id) {
        this.account_id = account_id;
    }
}
