package com.mongo.curdApp.repository;

import com.mongo.curdApp.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Waseem Saeed
 */
public interface UserRepository extends MongoRepository<User, String> {
}
