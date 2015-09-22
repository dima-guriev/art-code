package com.artcode.task1.entity;

import java.util.Date;

/**
 * Created by dimasik on 19.09.15.
 */
public class Employee {
    public static final String SEPARATOR = "\n";
    private String name;
    private int salary;
    private Address address;
    private boolean male;
    private int age;
    private int experience;
    private Date hireDate;

    public Employee(String name, int salary, Address address, boolean male, int age, int experience, Date hireDate) {
        setName(name);
        setSalary(salary);
        setAddress(address);
        setMale(male);
        setAge(age);
        setExperience(experience);
        setHireDate(hireDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        //salary is private info
        return getName() + SEPARATOR + "age = " + getAge() + SEPARATOR + (isMale() ? "male" : "female") + SEPARATOR + "experience = " + getExperience() + " month" + SEPARATOR + getAddress() + SEPARATOR;
    }
}
