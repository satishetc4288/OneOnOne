package com.cdk.springboot.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by rajputs on 7/17/17.
 */
@Document(collection = "meeting")
public class Meeting {

    @Id
    private String id;
    private String sender;
    private String receiver;
    private String feedback;
    private String meetingRoom;
    private String meetingDate;
    private String meetingFromTime;
    private String meetingToTime;

    public Meeting() {
    }

    public Meeting(String id, String sender, String receiver, String feedback, String meetingRoom, String meetingDate, String meetingFromTime, String meetingToTime) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.feedback = feedback;
        this.meetingRoom = meetingRoom;
        this.meetingDate = meetingDate;
        this.meetingFromTime = meetingFromTime;
        this.meetingToTime = meetingToTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(String meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    public String getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(String meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getMeetingFromTime() {
        return meetingFromTime;
    }

    public void setMeetingFromTime(String meetingFromTime) {
        this.meetingFromTime = meetingFromTime;
    }

    public String getMeetingToTime() {
        return meetingToTime;
    }

    public void setMeetingToTime(String meetingToTime) {
        this.meetingToTime = meetingToTime;
    }
}
