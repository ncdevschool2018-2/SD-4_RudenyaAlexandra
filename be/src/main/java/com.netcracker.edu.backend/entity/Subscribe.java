package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "subscribe", schema = "backend")
public class Subscribe {
    @Id
    @Column(name = "subscribe_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "account_id")
    private Long account_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public Subscribe() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscribe subscribe = (Subscribe) o;
        return Objects.equals(id, subscribe.id) &&
                Objects.equals(start_date, subscribe.start_date) &&
                Objects.equals(end_date, subscribe.end_date) &&
                Objects.equals(product_id, subscribe.product_id) &&
                Objects.equals(account_id, subscribe.account_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start_date, end_date, product_id, account_id);
    }
}
