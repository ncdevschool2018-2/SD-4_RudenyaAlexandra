package com.netcracker.edu.fapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.netcracker.edu.fapi.service.ProductDataService;

import java.sql.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscribeViewModel {
    private Long subscribeId;
    private Date startDate;
    private Date endDate;
    private ProductViewModel product;
    private AccountViewModel account;
    private List<FeatureViewModel> features;
    private boolean status;

    public SubscribeViewModel() {
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

    public ProductViewModel getProduct() {
        return product;
    }

    public void setProduct(ProductViewModel product) {
        this.product = product;
    }

    public AccountViewModel getAccount() {
        return account;
    }

    public void setAccount(AccountViewModel account) {
        this.account = account;
    }

    public List<FeatureViewModel> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeatureViewModel> features) {
        this.features = features;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
