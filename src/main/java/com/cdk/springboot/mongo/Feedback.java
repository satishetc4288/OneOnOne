package com.cdk.springboot.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by rajputs on 7/18/17.
 */
@Document(collection = "feedback")
public class Feedback {

    @Id
    private String id;
    private String meetingId;
    private String feedbacks;
    private List<String> performanceMatrices;

    public Feedback() {}

    public Feedback(String id, String meetingId, String feedbacks, List<String> performanceMatrices) {
        this.id = id;
        this.meetingId = meetingId;
        this.feedbacks = feedbacks;
        this.performanceMatrices = performanceMatrices;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public String getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(String feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<String> getPerformanceMatrices() {
        return performanceMatrices;
    }

    public void setPerformanceMatrices(List<String> performanceMatrices) {
        this.performanceMatrices = performanceMatrices;
    }
}
