package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Objects;
import java.sql.Date;

@Entity
@Table(name = "account", schema = "backend")
public class Account {
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_id;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "registration_date")
    private  String registration_date;

    @Column(name = "image_profile")
    private String image_profile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user_id;

    public Account() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(account_id, account.account_id) &&
                Objects.equals(last_name, account.last_name) &&
                Objects.equals(first_name, account.first_name) &&
                Objects.equals(registration_date, account.registration_date) &&
                Objects.equals(image_profile, account.image_profile) &&
                Objects.equals(user_id, account.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account_id, last_name, first_name, registration_date, image_profile, user_id);
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public String getImage_profile() {
        return image_profile;
    }

    public void setImage_profile(String image_profile) {
        this.image_profile = image_profile;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
}
