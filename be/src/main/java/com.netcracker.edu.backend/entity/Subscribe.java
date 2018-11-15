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

    @Column(name = "account_id")
    private Long accountId;

    @JoinColumn(name = "product_id")
    private Long productId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "feature_id")
    private List<Feature> features;

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }


    public Subscribe() {
    }

    public Subscribe(Date startDate, Date endDate, Long accountId, Long productId, List<Feature> features) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.accountId = accountId;
        this.productId = productId;
        this.features = features;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscribe subscribe = (Subscribe) o;
        return Objects.equals(subscribeId, subscribe.subscribeId) &&
                Objects.equals(startDate, subscribe.startDate) &&
                Objects.equals(endDate, subscribe.endDate) &&
                Objects.equals(productId, subscribe.productId) &&
                Objects.equals(accountId, subscribe.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscribeId, startDate, endDate, productId, accountId);
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
