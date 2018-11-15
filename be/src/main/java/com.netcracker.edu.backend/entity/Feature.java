package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "feature", schema = "backend")
public class Feature {
    @Id
    @Column(name = "feature_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long featureId;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "days")
    private  Integer days;

    @Column(name = "subscribe_id")
    private Long subscribeId;

    public Feature() {
    }

    public Feature(String title, Integer cost, Integer days, Long subscribeId) {
        this.title = title;
        this.cost = cost;
        this.days = days;
        this.subscribeId = subscribeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feature feature = (Feature) o;
        return Objects.equals(featureId, feature.featureId) &&
                Objects.equals(title, feature.title) &&
                Objects.equals(cost, feature.cost) &&
                Objects.equals(days, feature.days) &&
                Objects.equals(subscribeId, feature.subscribeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(featureId, title, cost, days, subscribeId);
    }

    public Long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
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

    public Long getSubscribeId() {
        return subscribeId;
    }

    public void setSubscribeId(Long subscribeId) {
        this.subscribeId = subscribeId;
    }
}
