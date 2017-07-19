package com.cdk.springboot.controller;

import com.cdk.springboot.mongo.User;
import com.cdk.springboot.mongo.repos.UserMRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

@RestController
@EnableAutoConfiguration
@EnableMongoRepositories({"com.cdk.oneonone"})
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserMRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Response login(@RequestBody User user) {

        if(user == null || user.getUsername() == null || user.getPassword() == null) {
            return Response.status(400).entity("Wrong user data")
                    .type("text/plain").build();
        }
        User searchUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(searchUser == null){
            return Response.status(400).entity("User is not authenticated")
                    .type("text/plain").build();
        }
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        try{
         jsonInString = mapper.writeValueAsString(searchUser);
        }catch (Exception exp){

        }
        return Response.status(200).entity(jsonInString)
                .type("text/plain").build();
    }

}
