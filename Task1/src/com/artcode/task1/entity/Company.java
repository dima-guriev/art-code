package com.artcode.task1.entity;

import java.util.List;

/**
 * Created by dimasik on 21.09.15.
 */
public class Company {
    public static final String SEPARATOR = "\n";
    private String name;
    private Address address;
    private int employeesAmount;
    private List<Employee> employees;

    public Company(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public int getEmployeesAmount() {
        return employeesAmount;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return getName() + SEPARATOR + address + SEPARATOR + "employees = " + getEmployeesAmount() + SEPARATOR + getEmployees();
    }
}
