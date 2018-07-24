package com.oocl.company.control;

import com.oocl.company.model.Company;
import com.oocl.company.model.Employee;
import com.oocl.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public List<Company> getAllCompanies(){
        return companyService.getCompanies();
    }

    @GetMapping("/companies/{order}")
    public Company getCompany(@PathVariable int order){
        return companyService.getCompanyByOrder(order);
    }

    @PostMapping("/companies")
    public Company addCompany(@RequestBody Company emp){
        return companyService.addCompany(emp);
    }

}
