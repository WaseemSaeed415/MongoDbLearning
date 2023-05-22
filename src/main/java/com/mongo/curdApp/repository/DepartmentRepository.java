package com.mongo.curdApp.repository;

import com.mongo.curdApp.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Waseem Saeed
 */
@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
}

