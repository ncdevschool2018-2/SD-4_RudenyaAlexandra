package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity//Указывает, что данный бин (класс) является сущностью.
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "name_category")
    private String nameCategory;

    public Category() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryId, category.categoryId) &&
                Objects.equals(nameCategory, category.nameCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, nameCategory);
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
