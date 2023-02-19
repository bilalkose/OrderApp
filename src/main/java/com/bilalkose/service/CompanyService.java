package com.bilalkose.service;

import com.bilalkose.model.Company;
import java.time.Month;
import java.util.Map;

public interface CompanyService {
    Map<Company,Double> findAllCompaniesForBillsInMonth(Month month);
}
