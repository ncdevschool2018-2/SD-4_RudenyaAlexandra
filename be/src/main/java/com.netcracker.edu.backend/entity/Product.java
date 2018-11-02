package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "backend")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "long_description")
    private  String long_description;

    @Column(name = "short_description")
    private  String short_description;

    @Column(name = "image")
    private String image;

    @Column(name = "type_id")
    private Long type_id;

    @Column(name = "comment_id")
    private Long comment_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getLong_description() {
        return long_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(cost, product.cost) &&
                Objects.equals(long_description, product.long_description) &&
                Objects.equals(short_description, product.short_description) &&
                Objects.equals(image, product.image) &&
                Objects.equals(type_id, product.type_id) &&
                Objects.equals(comment_id, product.comment_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cost, long_description, short_description, image, type_id, comment_id);
    }
}
