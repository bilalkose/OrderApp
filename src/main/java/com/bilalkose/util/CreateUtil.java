package com.bilalkose.util;

import com.bilalkose.model.Bill;
import com.bilalkose.model.Customer;

import java.util.List;

public interface CreateUtil {
    List<Customer> getCustomersList();
    List<Bill> getBillsList();
}
