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
    private Long subscribe_id;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account_id;

    public Subscribe() {
    }

    public Long getSubscribe_id() {
        return subscribe_id;
    }

    public void setSubscribe_id(Long subscribe_id) {
        this.subscribe_id = subscribe_id;
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

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public Account getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Account account_id) {
        this.account_id = account_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscribe subscribe = (Subscribe) o;
        return Objects.equals(subscribe_id, subscribe.subscribe_id) &&
                Objects.equals(start_date, subscribe.start_date) &&
                Objects.equals(end_date, subscribe.end_date) &&
                Objects.equals(product_id, subscribe.product_id) &&
                Objects.equals(account_id, subscribe.account_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscribe_id, start_date, end_date, product_id, account_id);
    }
}
