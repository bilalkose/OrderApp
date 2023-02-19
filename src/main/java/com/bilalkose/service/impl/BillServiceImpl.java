package com.bilalkose.service.impl;

import com.bilalkose.util.CreateUtil;
import com.bilalkose.util.CreateUtilImpl;
import com.bilalkose.model.Bill;
import com.bilalkose.service.BillService;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class BillServiceImpl implements BillService {
    CreateUtil createUtil = new CreateUtilImpl();

    @Override
    public List<Bill> getBillsList() {
        return createUtil.getBillsList();
    }

    @Override
    public List<Bill> findAllBillsForHigherThanTotalPrice(int totalPrice) {
        return this.createUtil.getBillsList().stream().filter(b->b.getTotalPrice()>totalPrice).collect(Collectors.toList());
    }

    @Override
    public OptionalDouble findAllBillsForHigherThanTotalPriceAverage(int totalPrice) {
        List<Bill> higherThanTotalPrice = this.createUtil.getBillsList().stream().filter(b -> b.getTotalPrice() > totalPrice).toList();
        return OptionalDouble.of(higherThanTotalPrice.stream().mapToDouble(h->h.getTotalPrice()).average().orElse(0));
    }
}
