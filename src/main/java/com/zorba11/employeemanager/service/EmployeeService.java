package com.zorba11.employeemanager.service;

import com.zorba11.employeemanager.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Repository
@Transactional
public class EmployeeService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee(1L, "Alen", "Software Developer"),
            new Employee(2L, "Wozniak", "Lead developer"),
            new Employee(3L, "Turing", "Researcher")
    ));

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employees.stream().filter(e -> e.getId().equals(id)).findFirst().get();
    }

    public Long addEmployee(Employee employee) {
        entityManager.persist(employee);
        return employee.getId();
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
