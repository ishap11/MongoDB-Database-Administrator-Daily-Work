package com.example.MongoDBAuth.repository;

import com.example.MongoDBAuth.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    // Find user by name (username)
    Optional<User> findByName(String name);
}
