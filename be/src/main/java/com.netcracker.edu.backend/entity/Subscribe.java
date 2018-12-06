package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subscribe", schema = "backend")
public class Subscribe {
    @Id
    @Column(name = "subscribe_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscribeId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "feature_id")
    private List<Feature> features;

    public List<Feature> getFeatures() {
        return features;
    }

    @Column(name = "status")
    private boolean status;

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }


    public Subscribe() {
    }

    public Long getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(Long subscribeId) {
        this.subscribeId = subscribeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Subscribe(Date startDate, Date endDate, Account account, Product product, List<Feature> features, boolean status) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.account = account;
        this.product = product;
        this.features = features;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscribe subscribe = (Subscribe) o;
        return status == subscribe.status &&
                Objects.equals(subscribeId, subscribe.subscribeId) &&
                Objects.equals(startDate, subscribe.startDate) &&
                Objects.equals(endDate, subscribe.endDate) &&
                Objects.equals(account, subscribe.account) &&
                Objects.equals(product, subscribe.product) &&
                Objects.equals(features, subscribe.features);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscribeId, startDate, endDate, account, product, features, status);
    }
}
