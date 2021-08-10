package com.zorba11.employeemanager.service;

import com.zorba11.employeemanager.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    public List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee(1L, "Alen", "Software Developer"),
            new Employee(2L, "Wozniak", "Lead developer"),
            new Employee(3L, "Turing", "Researcher")
    ));

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(Long id) {
        return employees.stream().filter(e -> e.getId().equals(id)).findFirst().get();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void updateEmployee(Long id, Employee employee) {
        employees.forEach(e -> {
            if (e.getId() == id)
                employees.set(Math.toIntExact(id), employee);
        });
    }

    public void deleteEmployee(Long id) {
        employees.removeIf(e -> e.getId().equals(id));
    }
}
