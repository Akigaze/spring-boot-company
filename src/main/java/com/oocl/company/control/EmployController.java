package com.oocl.company.control;

import com.oocl.company.model.Employee;
import com.oocl.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployController {

    @Autowired
    private EmployeeService empService;
}
