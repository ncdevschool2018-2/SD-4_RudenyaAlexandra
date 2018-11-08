package com.netcracker.edu.fapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductViewModel {
    private Long product_id;
    private String name;
    private Integer cost;
    private String long_description;
    private String short_description;
    private String image;
    private CategoryViewModel category_id;
    private CommentViewModel comment_id;

    public ProductViewModel() {
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
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

    public CategoryViewModel getCategory_id() {
        return category_id;
    }

    public void setCategory_id(CategoryViewModel category_id) {
        this.category_id = category_id;
    }

    public CommentViewModel getComment_id() {
        return comment_id;
    }

    public void setComment_id(CommentViewModel comment_id) {
        this.comment_id = comment_id;
    }
}
