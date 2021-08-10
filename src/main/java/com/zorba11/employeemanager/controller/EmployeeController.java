package com.zorba11.employeemanager.controller;

import com.zorba11.employeemanager.entity.Employee;
import com.zorba11.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @GetMapping("api/employees")
    public  List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("api/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("api/employees")
    public String addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);

        return "Employee added. Id: " + employee.getId();
    }

    @PutMapping("api/employees/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);

        return "Employee updated, ID: " + employee.getId();
    }

    @DeleteMapping("api/employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);

        return "Employee deleted, ID: " + id;
    }
}

