package com.sage.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by jonatannietoa on 29/3/17.
 */
@Entity
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private Date date;

    @OneToOne
    private Customer customer;

    private String description;
    private double amount;
    private Status status;

    public Invoice() {}

    public Invoice(Date date, Customer customer, String description, double amount, Status status) {
        this.date = date;
        this.customer = customer;
        this.description = description;
        this.amount = amount;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
