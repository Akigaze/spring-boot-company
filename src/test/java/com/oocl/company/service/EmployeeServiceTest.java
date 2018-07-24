package com.oocl.company.service;

import com.oocl.company.model.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class EmployeeServiceTest {
    @Test
    public void should_get_all_employees_when_call_getEmployees(){
        //give
        List<Employee> employees=new ArrayList<>();
        employees.add(new Employee(1,"Mark",22,"man",500));
        employees.add(new Employee(2,"Bale",21,"man",500));
        employees.add(new Employee(3,"Tracy",20,"woman",500));
        employees.add(new Employee(4,"Leo",22,"man",500));
        employees.add(new Employee(5,"Quinn",21,"woman",500));
        //when
        EmployeeService service=new EmployeeService(employees);
        List<Employee> result=service.getEmployees();
        //then
        assertThat(result,is(employees));
    }

    @Test
    public void should_get_specific_employee_when_call_getEmployeeById(){
        //give
        List<Employee> employees=new ArrayList<>();
        Employee except=new Employee(2,"Bale",21,"man",500);
        employees.add(new Employee(1,"Mark",22,"man",500));
        employees.add(except);
        employees.add(new Employee(3,"Tracy",20,"woman",500));
        employees.add(new Employee(4,"Leo",22,"man",500));
        employees.add(new Employee(5,"Quinn",21,"woman",500));
        //when
        EmployeeService service=new EmployeeService(employees);
        Employee result=service.getEmployeeById(2);
        //then
        assertThat(result.toString(),is(except.toString()));
    }
}
