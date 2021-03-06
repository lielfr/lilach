package org.cshaifasweng.winter.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private Long id;

    private String name;

    private String address;

    private String phone;

    private String openingHours;

    private Employee manager;

    private List<Employee> employees;

    private List<Customer> customers;

    @JsonIgnore
    private List<Complaint> complaints;

    private List<CatalogItem> catalogItems;

    @JsonIgnore
    private List<Order> orders;

    @JsonIgnore
    private List<Report> reports;

    public Store() {

    }

    public Store(String name, String address, String phone, String openingHours) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.openingHours = openingHours;
        this.employees = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.complaints = new ArrayList<>();
        this.catalogItems = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public Store(Store origin) {
        name = origin.name;
        address = origin.address;
        phone = origin.phone;
        openingHours = origin.openingHours;
        manager = origin.manager;
        this.employees = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.complaints = new ArrayList<>();
        this.catalogItems = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }

    public List<CatalogItem> getCatalogItems() {
        return catalogItems;
    }

    public void setCatalogItems(List<CatalogItem> catalogItems) {
        this.catalogItems = catalogItems;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
