package com.mongo.curdApp.service;

import com.mongo.curdApp.entity.Department;
import com.mongo.curdApp.entity.Employee;
import com.mongo.curdApp.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Waseem Saeed
 */
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;


    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);

    }

   public List<Department> findAll(){
        return departmentRepository.findAll();
    }

    public Department findDepartmentById(String deptId){
        return departmentRepository.findById(deptId).orElse(null);
    }
}
