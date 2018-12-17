package com.netcracker.edu.fapi.entity;

public class UpdateBalanceData {

    private Long id;
    private Integer amount;

    public UpdateBalanceData() {
    }

    public UpdateBalanceData(Long id, Integer amount) {
        this.id = id;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
