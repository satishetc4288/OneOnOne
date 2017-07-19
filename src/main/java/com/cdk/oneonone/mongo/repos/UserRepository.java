package com.cdk.oneonone.mongo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cdk.oneonone.mongo.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{name:'?0'}")
    public List<User> findCustomByName(String name);

    @Query("{username:'?0'}")
    public User findCustomByUsername(String username);

    @Query("{$and:[{username:'?0'},{password:'?1'}]}")
    public User findByUsernameAndPassword(String username, String password);

}