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

    @DeleteMapping("/companies/{order}")
    public void deleteCompany(@PathVariable int order){
        companyService.deleteCompanyByOrder(order);
    }

    @PutMapping("/companies/{order}")
    public void updateCompany(@PathVariable int order,@RequestBody Company company){
        companyService.updateCompany(order,company);
    }

    @GetMapping("/companies/{order}/employees")
    public List<Employee> getEmployeesOfCompany(@PathVariable int order){
        return companyService.getEmployeesOfCompanyEmployees(order);
    }

    @GetMapping("/companies/page/{page}/pageSize/{pageSize}")
    public List<Company> getCompanyPage(@PathVariable int page,@PathVariable int pageSize){
        return companyService.getCompanyPage(page,pageSize);
    }

}
