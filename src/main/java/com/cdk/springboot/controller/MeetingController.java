package com.cdk.springboot.controller;

import com.cdk.springboot.mongo.Meeting;
import com.cdk.springboot.mongo.User;
import com.cdk.springboot.mongo.repos.MeetingRepository;
import com.cdk.springboot.outlook.CalendarEvent2;
import com.cdk.springboot.outlook.CalendarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import java.text.ParseException;

import java.util.List;

@RestController
@EnableAutoConfiguration
@EnableMongoRepositories({"com.cdk"})
@RequestMapping("/api")
public class MeetingController{

    @Autowired
    MeetingRepository meetingRepository;

    @RequestMapping(value = "/insert/meeting", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Meeting> insertMeeting(@RequestBody Meeting meeting) {
        CalendarEvent2 cl = new CalendarEvent2(CalendarUtil.getMailerService());
        try {
            cl.createCal(meeting.getSender(), meeting.getReceiver(), meeting.getMeetingFromTime(), meeting.getMeetingDate(), meeting.getMeetingToTime(), meeting.getMeetingRoom(), "", "");
        } catch (MessagingException | ParseException | IOException e) {
            e.printStackTrace();
        }
        Meeting insertedMeeting = meetingRepository.insert(meeting);
        return new ResponseEntity<Meeting>(insertedMeeting, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/all/meetings", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Meeting>> getMeetings() {

        List<Meeting> insertedMeetings = meetingRepository.findAll();
        return new ResponseEntity<List<Meeting>>(insertedMeetings, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/all/meetings", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<List<Meeting>> getMeetingsBySender(@RequestBody User user) {

        List<Meeting> insertedMeetings = meetingRepository.findCustomBySender(user.getName());
        return new ResponseEntity<List<Meeting>>(insertedMeetings, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/meeting/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Meeting> getMeetingsById(@PathVariable("id") String id) {

        Meeting meeting = meetingRepository.findOne(id);
        return new ResponseEntity<Meeting>(meeting, HttpStatus.OK);
    }
}
