package com.oocl.company.service;

import com.oocl.company.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private List<Company> companies;

    public CompanyService() {
    }

    public CompanyService(List<Company> companies) {
        this.companies = companies;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public Company getCompanyByOrder(int order) {
        return companies.get(order-1);
    }
}
