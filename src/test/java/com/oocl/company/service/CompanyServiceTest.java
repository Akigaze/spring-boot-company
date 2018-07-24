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
}
