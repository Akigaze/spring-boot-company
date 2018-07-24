package com.oocl.company.service;

import com.oocl.company.model.Company;
import com.oocl.company.model.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CompanyServiceTest {
    @Test
    public void should_get_all_companies_when_call_getCompanies(){
        //give
        List<Company> companies=new ArrayList<>();
        companies.add(new Company());
        companies.add(new Company());
        //when
        CompanyService service=new CompanyService(companies);
        List<Company> result=service.getCompanies();
        //then
        assertThat(result,is(companies));
    }

    @Test
    public void should_get_specific_company_when_call_getCompanyByOrder(){
        //give
        List<Company> companies=new ArrayList<>();
        Company except=new Company();
        companies.add(new Company());
        companies.add(except);
        //when
        CompanyService service=new CompanyService(companies);
        Company result=service.getCompanyByOrder(2);
        //then
        assertThat(result,is(except));
    }

    @Test
    public void should_add_a_specific_Company_when_call_addCompany(){
        //give
        List<Company> companys=new ArrayList<>();
        Company except=new Company();
        companys.add(new Company());
        //when
        CompanyService service=new CompanyService(companys);
        service.addCompany(except);
        //then
        assertThat(companys.contains(except),is(true));
    }

    @Test
    public void should_delete_a_specific_Company_and_its_employees_by_id_when_call_deleteCompanyByOrder(){
        //give
        List<Company> companys=new ArrayList<>();
        List<Employee> employees=new ArrayList<>();

        Company except=new Company("OOCL",employees);
        employees.add(new Employee());
        companys.add(except);
        //when
        CompanyService service=new CompanyService(companys);
        service.deleteCompanyByOrder(1);
        //then
        assertThat(companys.contains(except),is(false));
        assertThat(employees.size(),is(0));
    }
}
