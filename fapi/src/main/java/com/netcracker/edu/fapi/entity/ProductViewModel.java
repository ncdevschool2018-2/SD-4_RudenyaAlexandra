package com.netcracker.edu.fapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductViewModel {
    private Long productId;
    private String name;
    private Integer cost;
    private String longDescription;
    private String shortDescription;
    private String image;
    private CategoryViewModel category;
    private CommentViewModel comment;

    public ProductViewModel() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public CategoryViewModel getCategory() {
        return category;
    }

    public void setCategory(CategoryViewModel category) {
        this.category = category;
    }

    public CommentViewModel getComment() {
        return comment;
    }

    public void setComment(CommentViewModel comment) {
        this.comment = comment;
    }
}
