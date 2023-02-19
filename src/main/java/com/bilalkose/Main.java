package com.bilalkose;

import com.bilalkose.service.BillService;
import com.bilalkose.service.CompanyService;
import com.bilalkose.service.CustomerService;
import com.bilalkose.service.impl.BillServiceImpl;
import com.bilalkose.service.impl.CompanyServiceImpl;
import com.bilalkose.service.impl.CustomerServiceImpl;

import java.time.Month;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerServiceImpl();
        BillService billService = new BillServiceImpl();
        CompanyService companyService = new CompanyServiceImpl();

        System.out.println("***** New Customer Creation");
        customerService.createCustomer(5, "User", "Test", billService.getBillsList().get(0));
        System.out.println("****************************************");


        System.out.println("***** List customers with the letter 'C' in them (only in name)");
        customerService.findCustomersByLetter("c").stream().forEach(System.out::print);
        System.out.println("****************************************");


        System.out.println("***** List total bills amount for customers who signed up in June");
        System.out.println("Total Price in June: " + customerService.findAllTotalPriceForCreateDate(Month.JUNE));
        System.out.println("****************************************");


        System.out.println("***** List all bills in the system");
        billService.getBillsList().stream().forEach(System.out::print);
        System.out.println("****************************************");


        System.out.println("***** List all bills for higher than total price 1500TL in the system");
        billService.findAllBillsForHigherThanTotalPrice(1500).forEach(System.out::print);
        System.out.println("****************************************");


        System.out.println("***** Calculate the average of bills prices over 1500TL in the system");
        System.out.println("Average of bills price over 1500TL: " + billService
                .findAllBillsForHigherThanTotalPriceAverage(1500)
                        .getAsDouble());
        System.out.println("****************************************");


        System.out.println("***** List the names of customers with bills price under 500TL in the system");
        customerService.findAllCustomersForLowerThanBillTotalPrice(500).forEach(System.out::print);
        System.out.println("****************************************");


        System.out.println("***** List the sectors of companies with an average bills total price of less than 750 in June");
        companyService.findAllCompaniesForBillsInMonth(Month.JUNE);
        System.out.println("****************************************");

    }
}