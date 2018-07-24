package com.oocl.company.control;

import com.oocl.company.model.Employee;
import com.oocl.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return empService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        return empService.getEmployeeById(id);
    }

    @GetMapping("/employees/male")
    public List<Employee> getMaleEmployee(){
        return empService.getEmployeeByGender("male");
    }

    @GetMapping("/employees/female")
    public List<Employee> getFemaleEmployee(){
        return empService.getEmployeeByGender("female");
    }

    @GetMapping("/employees/page/{page}/pageSize/{pageSize}")
    public List<Employee> getEmployeePage(@PathVariable int page,@PathVariable int pageSize){
        return empService.getEmployeesPage(page,pageSize);
    }

    @PostMapping("/employees")
    public boolean addEmployee(@RequestBody Employee emp){
        return empService.addEmployee(emp);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee emp){
        return empService.updateEmployee(id,emp);
    }

    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployee(@PathVariable int id){
        return empService.deleteEmployeeById(id);
    }
}
