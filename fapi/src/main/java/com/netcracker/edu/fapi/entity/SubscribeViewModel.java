package com.netcracker.edu.fapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.netcracker.edu.fapi.service.ProductDataService;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscribeViewModel {
    private Long subscribeId;
    @NotBlank
    @Pattern(regexp="yyyy-MM-dd")
    private Date startDate;
    @NotBlank
    @Pattern(regexp="yyyy-MM-dd")
    private Date endDate;
    @NotBlank
    private Object product;
    @NotBlank
    private Object account;
    private List<Object> features;
    @NotBlank
    private boolean status;

    public SubscribeViewModel() {
    }

    public SubscribeViewModel(Long subscribeId, @NotBlank @Pattern(regexp = "yyyy-MM-dd") Date startDate,
                              @NotBlank @Pattern(regexp = "yyyy-MM-dd")
            Date endDate, @NotBlank Object product, @NotBlank Object account,
                              List<Object> features, @NotBlank boolean status) {
        this.subscribeId = subscribeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.product = product;
        this.account = account;
        this.features = features;
        this.status = status;
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

    public Object getProduct() {
        return product;
    }

    public void setProduct(Object product) {
        this.product = product;
    }

    public Object getAccount() {
        return account;
    }

    public void setAccount(Object account) {
        this.account = account;
    }

    public List<Object> getFeatures() {
        return features;
    }

    public void setFeatures(List<Object> features) {
        this.features = features;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
