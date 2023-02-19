package com.bilalkose.service.impl;
import com.bilalkose.util.CreateUtil;
import com.bilalkose.util.CreateUtilImpl;
import com.bilalkose.model.Bill;
import com.bilalkose.model.Company;
import com.bilalkose.service.CompanyService;

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyServiceImpl implements CompanyService {
    CreateUtil createUtil = new CreateUtilImpl();

    @Override
    public Map<Company,Double> findAllCompaniesForBillsInMonth(Month month) {
        List<Bill> billList = createUtil.getBillsList();
        List<Bill> selectedMonth =  billList.stream().filter(b->b.getLocalDate().getMonth().getValue() == month.getValue()).toList(); //Month is selected
        Map<Company, Double> companiesWithTotalPrice = new HashMap<>(); //Companies and their bills total prices set a map

        for(int i=0; i<selectedMonth.size(); i++){
            // companiesWithTotalPrice set map by singular keys (companies)
            if(!companiesWithTotalPrice.containsKey(selectedMonth.get(i).getCompany())){
                companiesWithTotalPrice.put(selectedMonth.get(i).getCompany(), selectedMonth.get(i).getTotalPrice());
            }
            else{
                // if the same company, collect the total price and do merge
                companiesWithTotalPrice.merge(selectedMonth.get(i).getCompany(), selectedMonth.get(i).getTotalPrice(), Double::sum);
            }
        }

        for (Map.Entry entry : companiesWithTotalPrice.entrySet()) {
            System.out.println("key (company) : " + entry.getKey() + "; value (bills total price): " + entry.getValue());
        }

        return companiesWithTotalPrice;
    }
}
