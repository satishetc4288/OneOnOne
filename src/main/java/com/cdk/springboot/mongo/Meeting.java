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
    private String from;
    private String to;
    private String feedback;

    public Meeting(String id, String sender, String receiver, String from, String to, String feedback) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.from = from;
        this.to = to;
        this.feedback = feedback;
    }

    public Meeting() {
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id='" + id + '\'' +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
