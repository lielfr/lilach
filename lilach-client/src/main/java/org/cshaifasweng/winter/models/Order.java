package org.cshaifasweng.winter.models;

import java.util.*;

public class Order {
    private Long id;

    private DeliveryMethod deliveryMethod;

    private Date orderDate;

    private Date supplyDate;

    private String greeting;

    private boolean deliverToAnother;

    private String deliveryAddress;

    private String recipientMail;

    private OrderStatus status;

    private Customer orderedBy;

    private Store store;

    private List<Item> items;

    private Map<Long, Long> quantities;

    private double price;

    public Order() {
        this.items = new ArrayList<>();
    }

    public Order(Date supplyDate, Store store, Customer orderedBy, DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
        this.supplyDate = supplyDate;
        this.store = store;
        this.orderedBy = orderedBy;
        this.items = new ArrayList<>();
        this.status = OrderStatus.PENDING;
        this.quantities = new HashMap<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public Date getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(Date supplyDate) {
        this.supplyDate = supplyDate;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public boolean isDeliverToAnother() {
        return deliverToAnother;
    }

    public void setDeliverToAnother(boolean deliverToAnother) {
        this.deliverToAnother = deliverToAnother;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getRecipientMail() {
        return recipientMail;
    }

    public void setRecipientMail(String recipientMail) {
        this.recipientMail = recipientMail;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(Customer orderedBy) {
        this.orderedBy = orderedBy;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Map<Long, Long> getQuantities() {
        return quantities;
    }

    public void setQuantities(Map<Long, Long> quantities) {
        this.quantities = quantities;
    }
}




