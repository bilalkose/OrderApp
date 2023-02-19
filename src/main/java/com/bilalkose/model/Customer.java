package com.bilalkose.model;

public class Customer {
    private final int id;
    private final String name;
    private final String surName;
    private final boolean isActive;

    private Bill bill;

    public Customer(int id, String name, String surName, boolean isActive, Bill bill) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.isActive = isActive;
        this.bill = bill;
    }
    public Customer(int id, String name, String surName, Bill bill) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.isActive = false;
        this.bill = bill;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurName() {
        return surName;
    }
    public boolean isActive() {
        return isActive;
    }
    public Bill getBill() {
        return bill;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", billTotalPrice='" + bill.getTotalPrice() + '\'' +
                '}' + '\n';
    }


}
