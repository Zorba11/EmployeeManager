package com.zorba11.employeemanager.service;

import com.zorba11.employeemanager.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    public List<Employee> employees = Arrays.asList(
            new Employee(1L, "Alen", "Software Developer"),
            new Employee(2L, "Wozniak", "Lead developer"),
            new Employee(3L, "Turing", "Researcher")
    );

    public List<Employee> getAllEmployees() {
        return employees;
    }
}
