package com.bilalkose.service;

import com.bilalkose.model.Bill;

import java.util.List;
import java.util.OptionalDouble;

public interface BillService {
    List<Bill> getBillsList();
    List<Bill> findAllBillsForHigherThanTotalPrice(int totalPrice);
    OptionalDouble findAllBillsForHigherThanTotalPriceAverage(int totalPrice);

}
