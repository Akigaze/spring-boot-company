package com.oocl.company.service;

import com.oocl.company.model.Company;
import com.oocl.company.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    private List<Company> companies=new ArrayList<>();

    {
        List<Employee> emps1 = new ArrayList<>();
        emps1.add(new Employee(9, "java", 20, "male", 200));
        EmployeeService.employees.addAll(emps1);
        companies.add(new Company("OOCL", emps1));

        List<Employee> emps2 = new ArrayList<>();
        emps2.add(new Employee(12, "C", 20, "male", 200));
        EmployeeService.employees.addAll(emps2);
        companies.add(new Company("Oracle", emps2));

        List<Employee> emps3 = new ArrayList<>();
        emps3.add(new Employee(11, "Go", 15, "female", 200));
        EmployeeService.employees.addAll(emps3);
        companies.add(new Company("Tencent", emps3));

        List<Employee> emps4 = new ArrayList<>();
        emps4.add(new Employee(13, "javascript", 17, "male", 200));
        EmployeeService.employees.addAll(emps4);
        companies.add(new Company("Alipay", emps4));
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
