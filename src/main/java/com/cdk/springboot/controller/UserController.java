package com.cdk.springboot.controller;

import com.cdk.springboot.mongo.User;
import com.cdk.springboot.mongo.repos.UserMRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@EnableMongoRepositories({"com.cdk.oneonone"})
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserMRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public User login(@RequestBody User user) {

        if(user == null || user.getUsername() == null || user.getPassword() == null) {
            return null;
        }
        User searchUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(searchUser == null){
            return null;
        }
        return searchUser;
    }

}
