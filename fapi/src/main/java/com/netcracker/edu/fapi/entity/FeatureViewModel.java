package com.netcracker.edu.fapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeatureViewModel {
    private Long feature_id;
    private String title;
    private Integer cost;
    private Integer days;
    private Long subscribe_id;

    public FeatureViewModel() {
    }

    public Long getFeature_id() {
        return feature_id;
    }

    public void setFeature_id(Long feature_id) {
        this.feature_id = feature_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Long getSubscribe_id() {
        return subscribe_id;
    }

    public void setSubscribe_id(Long subscribe_id) {
        this.subscribe_id = subscribe_id;
    }
}
