package com.bilalkose.model;

import com.bilalkose.model.enums.EVatRate;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Bill {
    private final int billId;
    private final double totalPrice;
    private final EVatRate vatRate;
    private final LocalDate localDate;
    private final Company company;

    public Bill(int billId, double totalPrice, EVatRate vatRate, LocalDate localDate, Company company) {
        this.billId = billId;
        this.totalPrice = totalPrice;
        this.vatRate = vatRate;
        this.localDate = localDate;
        this.company = company;
        this.company.getBillsTotalPrices().add(this.totalPrice);
    }

    public Bill(int billId, double totalPrice, LocalDate localDate, Company company) {
        this.billId = billId;
        this.totalPrice = totalPrice;
        this.vatRate = EVatRate.NONE;
        this.localDate = localDate;
        this.company = company;
        this.company.getBillsTotalPrices().add(this.totalPrice);
    }

    public int getBillId() {
        return billId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    public EVatRate getVatRate() {
        return vatRate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", totalPrice=" + totalPrice +
                ", vatRate=" + vatRate +
                ", date=" + getLocalDate() +
                ", company=" + company.getCompanyName() +
                '}' + '\n';
    }
}
