package com.netcracker.edu.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "account", schema = "backend")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "accountId")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "image_profile")
    private String imageProfile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private List<Wallet> wallets;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscribe_id")
    private List<Subscribe> subscriptions;


    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", imageProfile='" + imageProfile + '\'' +
                ", user=" + user +
                ", wallets=" + wallets +
                ", subscriptions=" + subscriptions +
                '}';
    }

    public Account() {
    }

    public Account(String lastName, String firstName, LocalDate registrationDate, String imageProfile, User user, List<Wallet> wallets, List<Subscribe> subscriptions) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.registrationDate = registrationDate;
        this.imageProfile = imageProfile;
        this.user = user;
        this.wallets = wallets;
        this.subscriptions = subscriptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId) &&
                Objects.equals(lastName, account.lastName) &&
                Objects.equals(firstName, account.firstName) &&
                Objects.equals(registrationDate, account.registrationDate) &&
                Objects.equals(imageProfile, account.imageProfile) &&
                Objects.equals(user, account.user) &&
                Objects.equals(wallets, account.wallets) &&
                Objects.equals(subscriptions, account.subscriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, lastName, firstName, registrationDate, imageProfile, user, wallets, subscriptions);
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    public void setWallets(List<Wallet> wallets) {
        this.wallets = wallets;
    }

    public List<Subscribe> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscribe> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
