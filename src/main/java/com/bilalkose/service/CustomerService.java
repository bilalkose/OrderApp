package com.bilalkose.service;

import com.bilalkose.model.Bill;
import com.bilalkose.model.Customer;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public interface CustomerService {
    void createCustomer(int id,String name, String surname,Bill bill);
    List<Customer> findCustomersByLetter(String letter);
    List<Customer> findAllCustomersForLowerThanBillTotalPrice(int totalPrice);
    Double findAllTotalPriceForCreateDate(Month month);

}
