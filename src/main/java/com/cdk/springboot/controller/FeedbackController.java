package com.cdk.springboot.controller;

import com.cdk.springboot.mongo.Feedback;
import com.cdk.springboot.mongo.repos.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@EnableMongoRepositories({"com.cdk"})
@RequestMapping("/api")
public class FeedbackController{

    @Autowired
    FeedbackRepository feedbackRepository;

    @RequestMapping(value = "/get/all/feedbacks", method = RequestMethod.GET)
    @ResponseBody
    public List<Feedback> getFeedbacks() {

        return feedbackRepository.findAll();
    }

    @RequestMapping(value = "/insert/feedback", method = RequestMethod.POST)
    @ResponseBody
    public com.cdk.springboot.mongo.Feedback insertFeedback(@RequestBody Feedback feedback) {

        return feedbackRepository.insert(feedback);
    }

}
