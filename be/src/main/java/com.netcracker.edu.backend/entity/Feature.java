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
    private Long feature_id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "days")
    private  Integer days;

    @Column(name = "subscribe_id")
    private Long subscribe_id;

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

    public Feature() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feature feature = (Feature) o;
        return Objects.equals(feature_id, feature.feature_id) &&
                Objects.equals(title, feature.title) &&
                Objects.equals(cost, feature.cost) &&
                Objects.equals(days, feature.days) &&
                Objects.equals(subscribe_id, feature.subscribe_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feature_id, title, cost, days, subscribe_id);
    }
}
