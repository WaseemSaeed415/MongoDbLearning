package com.mongo.curdApp.repository;

import com.mongo.curdApp.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Waseem Saeed
 */
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    List<Employee> findByNameLike(String name);
    List<Employee> findByDepartment(String department);
}
