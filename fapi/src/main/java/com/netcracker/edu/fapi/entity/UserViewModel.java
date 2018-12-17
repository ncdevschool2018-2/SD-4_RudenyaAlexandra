package com.netcracker.edu.fapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserViewModel {
    private Long userId;
    @NotBlank
    @Size(min = 8, max = 24)
    private String login;
    @NotBlank
    @Size(min = 8)
    private String password;
    private Object account;
    @NotBlank
    private RoleModel role;

    public UserViewModel() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getAccount() {
        return account;
    }

    public void setAccount(Object account) {
        this.account = account;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    public UserViewModel(Long userId, String login, String password, Object account, RoleModel role) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.account = account;
        this.role = role;
    }
}
