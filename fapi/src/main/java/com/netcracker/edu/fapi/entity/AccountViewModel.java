package com.netcracker.edu.fapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountViewModel {
    private Long accountId;
    private String lastName;
    private String firstName;
    private LocalDate registrationDate;
    private String imageProfile;
    private UserViewModel user;
    private List<WalletViewModel> wallets;
    private List<SubscribeViewModel> subscriptions;

    public AccountViewModel() {
    }

    public UserViewModel getUser() {
        return user;
    }

    public void setUser(UserViewModel user) {
        this.user = user;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
    }

    public List<WalletViewModel> getWallets() {
        return wallets;
    }

    public void setWallets(List<WalletViewModel> wallets) {
        this.wallets = wallets;
    }

    public List<SubscribeViewModel> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<SubscribeViewModel> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
