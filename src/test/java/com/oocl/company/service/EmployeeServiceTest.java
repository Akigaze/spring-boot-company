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
        employees.add(new Employee(1,"Mark",22,"male",500));
        employees.add(new Employee(2,"Bale",21,"male",500));
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
        Employee except=new Employee(2,"Bale",21,"male",500);
        employees.add(new Employee(1,"Mark",22,"male",500));
        employees.add(except);
        //when
        EmployeeService service=new EmployeeService(employees);
        Employee result=service.getEmployeeById(2);
        //then
        assertThat(result.toString(),is(except.toString()));
    }

    @Test
    public void should_add_a_specific_employee_when_call_addEmployee(){
        //give
        List<Employee> employees=new ArrayList<>();
        Employee except=new Employee(2,"Bale",21,"male",500);
        employees.add(new Employee(1,"Mark",22,"male",500));
        //when
        EmployeeService service=new EmployeeService(employees);
        service.addEmployee(except);
        //then
        assertThat(employees.contains(except),is(true));
    }

    @Test
    public void should_delete_a_specific_employee_by_id_when_call_deleteEmployeeById(){
        //give
        List<Employee> employees=new ArrayList<>();
        Employee except=new Employee(2,"Bale",21,"male",500);
        employees.add(new Employee(1,"Mark",22,"male",500));
        employees.add(except);
        //when
        EmployeeService service=new EmployeeService(employees);
        Employee emp=service.deleteEmployeeById(2);
        //then
        assertThat(employees.contains(except),is(false));
        assertThat(emp,is(except));
    }

    @Test
    public void should_update_a_specific_employee_when_call_updateEmployee(){
        //give
        List<Employee> employees=new ArrayList<>();
        Employee except=new Employee(2,"Bale",21,"male",500);
        employees.add(new Employee(1,"Mark",22,"male",500));
        employees.add(except);
        Employee newEmp=new Employee(2,"Mark",25,"male",600);
        //when
        EmployeeService service=new EmployeeService(employees);
        Employee emp=service.updateEmployee(2,newEmp);
        //then
        assertThat(except.toString(),is(newEmp.toString()));
    }

    @Test
    public void should_get_male_employees_when_search_men_by_getEmployeeByGender(){
        //give
        List<Employee> employees=new ArrayList<>();
        Employee male=new Employee(2,"Bale",21,"male",500);
        Employee female=new Employee(1,"Mark",22,"female",500);
        employees.add(male);
        employees.add(female);
        //when
        EmployeeService service=new EmployeeService(employees);
        List<Employee> menEmp=service.getEmployeeByGender("male");
        //then
        assertThat(menEmp.contains(male),is(true));
        assertThat(menEmp.contains(female),is(false));
    }

    @Test
    public void should_get_employees_by_page_when_getEmployeesPage(){
        //give
        List<Employee> employees=new ArrayList<>();
        Employee emp1=new Employee(3,"Tracy",20,"female",500);
        Employee emp2=new Employee(4,"Leo",22,"male",500);
        Employee emp3=new Employee(5,"Quinn",21,"female",500);
        employees.add(new Employee(1,"Mark",22,"male",500));
        employees.add(new Employee(2,"Bale",21,"male",500));
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        int pageId=2;
        int pageSize=2;
        //when
        EmployeeService service=new EmployeeService(employees);
        List<Employee> emps=service.getEmployeesPage(pageId,pageSize);
        //then
        assertThat(emps.contains(emp1),is(true));
        assertThat(emps.contains(emp2),is(true));
        assertThat(emps.contains(emp3),is(false));
    }
}
