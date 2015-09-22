package com.artcode.task1.logic;

import com.artcode.task1.entity.Address;
import com.artcode.task1.entity.Company;
import com.artcode.task1.entity.Employee;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dimasik on 21.09.15.
 */
public class CompanyCreator {
    public static Company defaultCompany() {
        String defaultValues = "A,B,C,D,E,F,G,H,I,J";
        List<Employee> employees = Arrays.stream(defaultValues.split(",")).map(s -> {
            int i = defaultValues.indexOf(s);
            return new Employee(s, i * 300, new Address(s + "country", s + "city", s + " st", i), i % 3 == 0, i * 4, i * 3, new Date(System.currentTimeMillis()));
        }).collect(Collectors.toList());
        Company company = new Company("MyCompany", new Address("MyCountry", "MyCity", "MyStreet", 12));
        company.setEmployees(employees);
        return company;
    }
}
