package com.oocl.company.control;

import com.oocl.company.model.Employee;
import com.oocl.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return empService.getEmployees();
    }
}
