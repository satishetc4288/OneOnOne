package com.cdk.oneonone.controllers;

import com.cdk.oneonone.mongo.Feedback;
import com.cdk.oneonone.mongo.repos.FeedbackRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@EnableAutoConfiguration
@RequestMapping("/cdk")
public class FeedbackController{

  //  @Autowired
    FeedbackRepository feedbackRepository;

    @RequestMapping(value = "/get/all/feedbacks", method = RequestMethod.GET)
    @ResponseBody
    public List<Feedback> getFeedbacks() {

        return feedbackRepository.findAll();
    }

    @RequestMapping(value = "/insert/feedback", method = RequestMethod.POST)
    @ResponseBody
    public Feedback insertFeedback(@RequestBody Feedback feedback) {

        return feedbackRepository.insert(feedback);
    }

}
