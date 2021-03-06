package org.cshaifasweng.winter.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


public class Transaction {
    private Long id;

    private Date date;

    private String description;

    private double amount;

    @JsonIgnore
    private Customer customer;

    public Transaction() {
    }

    public Transaction(Date date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
