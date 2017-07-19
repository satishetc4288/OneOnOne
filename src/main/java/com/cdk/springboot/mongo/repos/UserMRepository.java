package com.cdk.springboot.mongo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cdk.springboot.mongo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMRepository extends MongoRepository<User, String> {

    @Query("{name:'?0'}")
    public List<User> findCustomByName(String name);

    @Query("{username:'?0'}")
    public User findCustomByUsername(String username);

    @Query("{$and:[{username:'?0'},{password:'?1'}]}")
    public User findByUsernameAndPassword(String username, String password);

}