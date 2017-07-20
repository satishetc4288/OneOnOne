package com.cdk.springboot.controller;

import com.cdk.springboot.mongo.Feedback;
import com.cdk.springboot.mongo.Meeting;
import com.cdk.springboot.mongo.repos.FeedbackRepository;
import com.cdk.springboot.mongo.repos.MeetingRepository;
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
public class FeedbackController{

    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    MeetingRepository meetingRepository;

    @RequestMapping(value = "/get/all/feedbacks", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Feedback>> getFeedbacks() {

        List<Feedback> feedbacks = feedbackRepository.findAll();
        return new ResponseEntity<List<Feedback>>(feedbacks, HttpStatus.OK);
    }

    @RequestMapping(value = "/insert/feedback", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Feedback> insertFeedback(@RequestBody Feedback feedback) {

        Feedback feedbackNew = feedbackRepository.insert(feedback);
        return new ResponseEntity<Feedback>(feedbackNew, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/user/feedbacks", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<List<Feedback>> getUserFeedbacks(@RequestBody Meeting meeting) {

        List<Meeting> meetingList = meetingRepository.findCustomByReceiver(meeting.getReceiver());
        List<Feedback> feedbacks = new ArrayList<>();
        meetingList.forEach(meetingNew -> {
            feedbacks.addAll(feedbackRepository.findCustomByMeetingId(meetingNew.getId()));
        });
        return new ResponseEntity<List<Feedback>>(feedbacks, HttpStatus.OK);
    }

}
