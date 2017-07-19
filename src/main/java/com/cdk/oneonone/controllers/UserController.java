package com.cdk.oneonone.controllers;

import com.cdk.oneonone.mongo.User;
import com.cdk.oneonone.mongo.repos.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@RequestMapping("/cdk")
public class UserController {

   // @Autowired
    UserRepository userRepository;

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
