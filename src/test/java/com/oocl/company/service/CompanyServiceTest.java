package com.oocl.company.service;

import com.oocl.company.model.Company;
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
        List<Company> Companys=new ArrayList<>();
        Company except=new Company();
        Companys.add(new Company());
        //when
        CompanyService service=new CompanyService(Companys);
        service.addCompany(except);
        //then
        assertThat(Companys.contains(except),is(true));
    }
}
