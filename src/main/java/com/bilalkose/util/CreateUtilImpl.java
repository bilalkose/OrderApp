package com.bilalkose.util;

import com.bilalkose.model.Bill;
import com.bilalkose.model.Company;
import com.bilalkose.model.Customer;
import com.bilalkose.model.enums.ESector;
import com.bilalkose.model.enums.EVatRate;

import java.time.LocalDate;
import java.util.*;

public class CreateUtilImpl implements CreateUtil {
    List<Customer> customers = new ArrayList<>();
    List<Bill> bills = new ArrayList<>();
    Customer customer1,customer2,customer3,customer4;
    Bill bill1,bill2,bill3,bill4,bill5,bill6,bill7;
    Company company1, company2, company3, company4, company5;
    LocalDate date1, date2, date3, date4;

    public static final Double BILL_1_TOTAL_PRICE = 1000.0;
    public static final Double BILL_2_TOTAL_PRICE = 480.0;
    public static final Double BILL_3_TOTAL_PRICE = 1200.0;
    public static final Double BILL_4_TOTAL_PRICE = 350.0;
    public static final Double BILL_5_TOTAL_PRICE = 1700.0;
    public static final Double BILL_6_TOTAL_PRICE = 2200.0;
    public static final Double BILL_7_TOTAL_PRICE = 2000.0;

    public CreateUtilImpl() {
        datesInit();
        companiesInit();
        billsInit();
        customersInit();
    }
    public List<Customer> getCustomersList(){
        return customers;
    }
    public List<Bill> getBillsList(){
        return bills;
    }

    private void billsInit() {
        this.bill1 = new Bill(1,BILL_1_TOTAL_PRICE, EVatRate.VERY_LOW, date1,company1);
        this.bill2 = new Bill(2,BILL_2_TOTAL_PRICE, EVatRate.LOW,date2,company2);
        this.bill3 = new Bill(3,BILL_3_TOTAL_PRICE, EVatRate.MEDIUM,date3,company3);
        this.bill4 = new Bill(4,BILL_4_TOTAL_PRICE, EVatRate.MEDIUM,date3,company3);
        this.bill5 = new Bill(5,BILL_5_TOTAL_PRICE, EVatRate.HIGH,date1,company4);
        this.bill6 = new Bill(6,BILL_6_TOTAL_PRICE, EVatRate.VERY_HIGH,date4,company5);
        this.bill7 = new Bill(7,BILL_7_TOTAL_PRICE, date1,company1);
        bills.add(bill1); bills.add(bill2); bills.add(bill3); bills.add(bill4); bills.add(bill5); bills.add(bill6); bills.add(bill7);
    }

    private void customersInit() {
        this.customer1 = new Customer(1,"Bilal","Köse",true,bill1);
        this.customer2 = new Customer(2,"Ali","Kaya",true,bill2);
        this.customer3 = new Customer(3,"Veli","Yazıcı",true,bill3);
        this.customer4 = new Customer(4,"Muratcan","Arslan",true,bill4);
        customers.add(customer1); customers.add(customer2); customers.add(customer3); customers.add(customer4);
    }

    private void companiesInit() {
        this.company1 = new Company(1,"Company Name 1", ESector.INFORMATION_TECHNOLOGIES);
        this.company2 = new Company(2,"Company Name 2", ESector.FINANCE);
        this.company3 = new Company(3,"Company Name 3", ESector.CONSTRUCTION);
        this.company4 = new Company(4,"Company Name 4", ESector.EDUCATION);
        this.company5 = new Company(5,"Company Name 5", ESector.BUSINESS);
    }

    private void datesInit() {
        this.date1 = LocalDate.of(2022,6,20);
        this.date2 = LocalDate.of(2022,5,16);
        this.date3 = LocalDate.of(2022,3,11);
        this.date4 = LocalDate.of(2022,1,25);
    }
}