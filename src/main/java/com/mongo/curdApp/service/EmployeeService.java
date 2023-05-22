package com.mongo.curdApp.service;

import com.mongo.curdApp.entity.Department;
import com.mongo.curdApp.entity.Employee;
import com.mongo.curdApp.repository.DepartmentRepository;
import com.mongo.curdApp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Waseem Saeed
 */
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public Employee createEmployee(Employee employee, String departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public List<Employee> getAllEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public List<Employee> searchEmployeesByName(String name) {
        return employeeRepository.findByNameLike(name);
    }


}
