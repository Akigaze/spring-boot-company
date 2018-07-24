package com.oocl.company.service;

import com.oocl.company.model.Company;
import com.oocl.company.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    private List<Company> companies;

    {
        companies=new ArrayList<>();
        companies.add(new Company("OOCL",EmployeeService.employees.subList(1,2)));
        companies.add(new Company("Oracle",EmployeeService.employees.subList(3,4)));
        companies.add(new Company("Tencent",EmployeeService.employees.subList(2,3)));
        companies.add(new Company("Alipay",EmployeeService.employees.subList(4,5)));
    }

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
        EmployeeService.employees.addAll(company.getEmployees());
        return company;
    }

    public void deleteCompanyByOrder(int order) {
        Company company=companies.get(order-1);
        EmployeeService.employees.removeAll(company.getEmployees());
        company.getEmployees().clear();
        companies.remove(company);
    }

    public void updateCompany(int order, Company newCompany) {
        Company company=companies.get(order-1);
        company.setCompanyName(newCompany.getCompanyName());
        company.setEmployees(newCompany.getEmployees());
        company.setEmployeeNumber(newCompany.getEmployeeNumber());
    }

    public List<Employee> getEmployeesOfCompanyEmployees(int order) {
        return companies.get(order-1).getEmployees();
    }

    public List<Company> getCompanyPage(int pageId, int pageSize) {
        int index=(pageId-1)*pageSize+1;
        int end=pageId*pageSize+1;
        List<Company> selections=new ArrayList<>();

        while (index<end&&index<=companies.size()){
            selections.add(companies.get(index-1));
            index++;
        }
        return selections;
    }
}
