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
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "registration_date")
    private  Date registrationDate;

    @Column(name = "image_profile")
    private String imageProfile;

    @Column(name = "user_id")
    private Long user_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Account() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(lastName, account.lastName) &&
                Objects.equals(firstName, account.firstName) &&
                Objects.equals(registrationDate, account.registrationDate) &&
                Objects.equals(imageProfile, account.imageProfile) &&
                Objects.equals(user_id, account.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, registrationDate, imageProfile, user_id);
    }
}
