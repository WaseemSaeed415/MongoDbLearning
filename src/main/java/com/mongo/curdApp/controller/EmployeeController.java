package com.mongo.curdApp.controller;

import com.mongo.curdApp.dto.EmployeeDto;
import com.mongo.curdApp.entity.Employee;
import com.mongo.curdApp.entity.User;
import com.mongo.curdApp.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Waseem Saeed
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee=new Employee();
        employee.setDesignation(employeeDto.getDesignation());
        employee.setName(employeeDto.getName());

        return employeeService.createEmployee(employee,employeeDto.getDeptId());
    }

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/findEmployee")
    public List<Employee> getAllEmployeeByDepartment(@RequestBody EmployeeDto employeeDto) {
        return employeeService.getAllEmployeesByDepartment(employeeDto.getName());
    }

    @PostMapping("/search")
    public List<Employee> searchEmployeesByName(@RequestBody EmployeeDto employeeDto) {

        return employeeService.searchEmployeesByName(employeeDto.getName());
    }

}
