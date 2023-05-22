package com.mongo.curdApp.controller;

import com.mongo.curdApp.entity.Department;
import com.mongo.curdApp.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Waseem Saeed
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @PostMapping
    public Department createUser(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Department getUserById(@PathVariable String id) {
        return departmentService.findDepartmentById(id);
    }
}
