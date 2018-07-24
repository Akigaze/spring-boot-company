package com.oocl.company.service;

import com.oocl.company.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees;

    {
        employees=new ArrayList<>();
        employees.add(new Employee(1,"Mark",22,"man",500));
        employees.add(new Employee(2,"Bale",21,"man",500));
        employees.add(new Employee(3,"Tracy",20,"woman",500));
        employees.add(new Employee(4,"Leo",22,"man",500));
        employees.add(new Employee(5,"Quinn",21,"woman",500));
    }

}
