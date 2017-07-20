package com.cdk.springboot.controller;

import com.cdk.springboot.mongo.Meeting;
import com.cdk.springboot.mongo.User;
import com.cdk.springboot.mongo.repos.UserMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@EnableMongoRepositories({"com.cdk"})
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserMRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<User> login(@RequestBody User user) {

        if(user == null || user.getUsername() == null || user.getPassword() == null) {
            return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
        }
        User searchUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(searchUser == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<User>(searchUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/all/users", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userRepository.findAll();
        if(users == null || users.isEmpty()){
            return new ResponseEntity<List<User>>(new ArrayList<User>(), HttpStatus.OK);
        }
        return  new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/insert/user", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<User> insertUser(@RequestBody User user) {

        User insertedUser = userRepository.insert(user);
        return new ResponseEntity<User>(insertedUser, HttpStatus.OK);
    }

}
