package com.netcracker.edu.fapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.netcracker.edu.fapi.service.ProductDataService;

import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscribeViewModel {
    private Long subscribe_id;
    private Date start_date;
    private Date end_date;
    private ProductViewModel product_id;
    private AccountViewModel account_id;

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

    public ProductViewModel getProduct_id() {
        return product_id;
    }

    public void setProduct_id(ProductViewModel product_id) {
        this.product_id = product_id;
    }

    public AccountViewModel getAccount_id() {
        return account_id;
    }

    public void setAccount_id(AccountViewModel account_id) {
        this.account_id = account_id;
    }
}
