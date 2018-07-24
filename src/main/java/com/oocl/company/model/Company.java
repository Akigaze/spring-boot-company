package com.oocl.company.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Company {
    private String companyName;
    private int employeeNumber;

    @Autowired
    private List<Employee> employees;

    public Company() {
    }

    public Company(String companyName, List<Employee> employees) {
        this.companyName = companyName;
        this.employeeNumber = employees.size();
        this.employees = employees;
    }

    public Company(String companyName, int employeeNumber,List<Employee> employees) {
        this.companyName = companyName;
        this.employeeNumber = employeeNumber;
        this.employees = employees;

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", employeeNumber=" + employeeNumber +
                ", employees=" + employees +
                '}';
    }
}
