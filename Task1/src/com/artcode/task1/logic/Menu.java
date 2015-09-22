package com.artcode.task1.logic;

import com.artcode.task1.entity.Address;
import com.artcode.task1.entity.Company;
import com.artcode.task1.entity.Employee;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by dimasik on 21.09.15.
 */
public class Menu {
    private static Company company;

    public static void showMenu(Company company) {
        Menu.company = company;
        showMenu(0);
    }

    private static void showMenu(int command) {
        switch (command) {
            case 0:
                printCommands();
                showMenu(readCommand());
                break;
            case 1:
                System.out.println(company);
                break;
            case 2:
                System.out.println(company.getEmployees());
                break;
            case 3:
                company.getEmployees().stream().filter(employee -> employee.getExperience() > 12).forEach(System.out::println);
                break;
            case 4:
                company.getEmployees().stream().filter(employee -> !employee.isMale()).
                        filter(employee1 -> "Kiev".equals(employee1.getAddress().getCity())).forEach(System.out::println);
                break;
            case 5:
                addEmployee();
                break;
            case 6:
                System.out.println("Enter an employee index");
                company.getEmployees().remove(readCommand());
                break;
            case 7:
                company.setEmployees(company.getEmployees().stream().filter(employee ->
                        employee.getSalary() >= 1000 && employee.getExperience() >= 12).collect(Collectors.toList()));
                break;
            case 8:
                System.out.println("Enter an employee index");
                changeEmployee(company.getEmployees().get(readCommand()));
                break;
            case 9:
                company.getEmployees().stream().sorted(Comparator.comparing(Employee::isMale)).forEach(System.out::println);
                break;
            case 10:
                company.getEmployees().stream().filter(employee -> {
                    long workingPeriod = employee.getHireDate().getTime() - System.currentTimeMillis();
                    workingPeriod = TimeUnit.HOURS.convert(workingPeriod, TimeUnit.MILLISECONDS);
                    return workingPeriod > 100 && workingPeriod < 200;
                }).forEach(System.out::println);
                break;
            default:
                System.exit(0);
        }
        showMenu(0);
    }

    private static void changeEmployee(Employee employee) {
        Optional<Employee> optional = parseEmployee();
        if (optional.isPresent()) {
            Employee changedEmployee = optional.get();
            employee.setName(changedEmployee.getName());
            employee.setHireDate(changedEmployee.getHireDate());
            employee.setExperience(changedEmployee.getExperience());
            employee.setAge(changedEmployee.getAge());
            employee.setAddress(changedEmployee.getAddress());
            employee.setMale(changedEmployee.isMale());
            employee.setSalary(changedEmployee.getSalary());
        }
    }

    private static void addEmployee() {
        company.getEmployees().add(parseEmployee().get());
    }

    private static Optional<Employee> parseEmployee() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter employee name");
            String name = scanner.next();
            System.out.println("Enter employee salary");
            int salary = scanner.nextInt();
            System.out.println("Enter employee address");
            System.out.println("Enter employee country");
            String country = scanner.next();
            System.out.println("Enter employee city");
            String city = scanner.next();
            System.out.println("Enter employee street");
            String street = scanner.next();
            System.out.println("Enter employee building");
            int building = scanner.nextInt();
            Address address = new Address(country, city, street, building);
            System.out.println("Is employee male?");
            boolean male = scanner.nextBoolean();
            System.out.println("Enter employee age");
            int age = scanner.nextInt();
            System.out.println("Enter employee experience");
            int experience = scanner.nextInt();
            return Optional.of(new Employee(name, salary,
                    address, male, age, experience, new Date(System.currentTimeMillis())));
        } catch (InputMismatchException e) {
            System.out.println("Ooops...");
            parseEmployee();
        }
        return Optional.empty();
    }

    private static int readCommand() {
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You type wrong command, try again");
            readCommand();
        }
        return 0;
    }

    private static void printCommands() {
        System.out.println("Please, choose command");
        System.out.println("1. Read about company");
        System.out.println("2. View list of employees");
        System.out.println("3. View employees, which work more than year.");
        System.out.println("4. View employees, which are girls and live in Kiev");
        System.out.println("5. Add an employee");
        System.out.println("6. Fire an employee");
        System.out.println("7.Fire an employee, with salary less then 1000 and which works less then year");
        System.out.println("8.Change an employee information");
        System.out.println("9.View list of employees: first women and then men");
        System.out.println("10.View employees, which works between 100 and 200 hours");
        System.out.println("Other number for exit(except 0)");
    }
}
