package com.bilalkose.model;

import com.bilalkose.model.enums.ESector;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private final int companyId;
    private final String companyName;
    private final ESector sector;
    private final List<Double> billsTotalPrices;

    public Company(int companyId, String companyName, ESector sector) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.sector = sector;
        this.billsTotalPrices = new ArrayList<>();
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public ESector getSector() {
        return sector;
    }

    public List<Double> getBillsTotalPrices() {
        return billsTotalPrices;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", companySector='" + sector + '\'' +
                '}';
    }
}
