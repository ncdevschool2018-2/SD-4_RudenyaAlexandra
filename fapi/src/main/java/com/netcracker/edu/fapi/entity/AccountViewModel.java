package com.netcracker.edu.fapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountViewModel {
    private Long accountId;
    @Size(min = 2, max = 20)
    private String lastName;
    @Size(min = 2, max = 20)
    private String firstName;
    @NotBlank
    @Pattern(regexp="yyyy-MM-dd")
    private Date registrationDate;
    private String imageProfile;
    @NotBlank
    private Object user;
    private Object wallets;
    private List<Object> subscribes;

    public AccountViewModel() {
    }

    public AccountViewModel(Long accountId, @Size(min = 2, max = 20) String lastName, @Size(min = 2, max = 20)
            String firstName, @NotBlank @Pattern(regexp = "yyyy-MM-dd") Date registrationDate,
                            String imageProfile, @NotBlank Object user, Object wallets, List<Object> subscribes) {
        this.accountId = accountId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.registrationDate = registrationDate;
        this.imageProfile = imageProfile;
        this.user = user;
        this.wallets = wallets;
        this.subscribes = subscribes;
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public Object getWallets() {
        return wallets;
    }

    public void setWallets(Object wallets) {
        this.wallets = wallets;
    }

    public List<Object> getSubscribes() {
        return subscribes;
    }

    public void setSubscribes(List<Object> subscribes) {
        this.subscribes = subscribes;
    }
}