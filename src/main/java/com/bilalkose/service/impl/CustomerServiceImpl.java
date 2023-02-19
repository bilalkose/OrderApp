package com.bilalkose.service.impl;
import com.bilalkose.util.CreateUtil;
import com.bilalkose.util.CreateUtilImpl;
import com.bilalkose.model.Bill;
import com.bilalkose.model.Customer;
import com.bilalkose.service.CustomerService;

import java.time.Month;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CreateUtil createUtil = new CreateUtilImpl();

    @Override
    public void createCustomer(int id, String name, String surname, Bill bill) {
        createUtil.getCustomersList().add(new Customer(id,name,surname,bill));
        System.out.println(name + " " + surname + " - user has been created");
    }

    @Override
    public List<Customer> findCustomersByLetter(String letter) {
        return createUtil.getCustomersList().stream().filter(ab -> ab.getName().contains(letter)).toList();
    }

    @Override
    public List<Customer> findAllCustomersForLowerThanBillTotalPrice(int totalPrice) {
        List<Customer> customerList = createUtil.getCustomersList();
        return customerList.stream().filter(c -> c.getBill().getTotalPrice() < totalPrice).toList();
    }

    @Override
    public Double findAllTotalPriceForCreateDate(Month month) {
        List<Bill> billList = createUtil.getBillsList();
        List<Bill> selectedMonth =  billList.stream().filter(b->b.getLocalDate().getMonth().getValue() == month.getValue()).toList();
        return selectedMonth.stream().map(x->x.getTotalPrice()).reduce(0.0,Double::sum);
    }
}
