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

    public EmployeeService(List<Employee> employees) {
        this.employees=employees;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public Employee getEmployeeById(int id) {
        Employee emp=employees.stream().filter(e->e.getId()==id).findFirst().get();
        return emp;
    }

    public boolean addEmployee(Employee emp) {
        boolean result=employees.add(emp);
        return result;
    }

    public Employee deleteEmployeeById(int id) {
        Employee emp=getEmployeeById(id);
        employees.remove(emp);
        return emp;
    }

    public Employee updateEmployee(int id, Employee newEmp) {
        Employee emp=getEmployeeById(id);
        emp.setAge(newEmp.getAge());
        emp.setGender(newEmp.getGender());
        emp.setName(newEmp.getName());
        emp.setSalary(newEmp.getSalary());
        return emp;
    }
}
