package com.cdk.springboot.controller;

import com.cdk.springboot.mongo.Meeting;
import com.cdk.springboot.mongo.repos.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@EnableMongoRepositories({"com.cdk"})
@RequestMapping("/api")
public class MeetingController{

    @Autowired
    MeetingRepository meetingRepository;

    @RequestMapping(value = "/insert/meeting", method = RequestMethod.POST)
    @ResponseBody
    public Meeting insertMeeting(@RequestBody Meeting meeting) {

        return meetingRepository.insert(meeting);
    }

    @RequestMapping(value = "/get/all/meetings", method = RequestMethod.GET)
    @ResponseBody
    public List<Meeting> getMeetings() {

        return meetingRepository.findAll();
    }
}
