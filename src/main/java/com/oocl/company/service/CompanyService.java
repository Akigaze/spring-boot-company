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

    public Company addCompany(Company company) {
        companies.add(company);
        return company;
    }

    public void deleteCompanyByOrder(int order) {
        Company company=companies.get(order-1);
        company.getEmployees().clear();
        companies.remove(company);
    }

    public void updateCompany(int order, Company newCompany) {
        Company company=companies.get(order-1);
        company.setCompanyName(newCompany.getCompanyName());
        company.setEmployees(newCompany.getEmployees());
        company.setEmployeeNumber(newCompany.getEmployeeNumber());
    }
}
