package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity//Указывает, что данный бин (класс) является сущностью.
@Table(name = "user")
public class Category {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long category_id;

    @Column(name = "name_category")
    private String name_category;

    public Category() {
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(category_id, category.category_id) &&
                Objects.equals(name_category, category.name_category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category_id, name_category);
    }
}
