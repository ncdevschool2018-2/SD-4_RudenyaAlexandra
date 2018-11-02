package com.netcracker.edu.fapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscribeViewModel {
    private Long subscribe_id;
    private Date start_date;
    private Date end_date;
    private Integer product_id;
    private Integer account_id;

    public SubscribeViewModel() {
    }

    public Long getSubscribe_id() {
        return subscribe_id;
    }

    public void setSubscribe_id(Long subscribe_id) {
        this.subscribe_id = subscribe_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }
}
