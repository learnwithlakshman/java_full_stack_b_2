package com.lwl.quizer.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lwl.quizer.domain.User;

public interface UserRepo extends MongoRepository<User, String> {

}
