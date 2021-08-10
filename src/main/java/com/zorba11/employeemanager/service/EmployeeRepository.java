package com.zorba11.employeemanager.service;

import com.zorba11.employeemanager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
