package com.cdk.springboot.mongo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cdk.springboot.mongo.Feedback;
import com.cdk.springboot.mongo.Meeting;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rajputs on 7/18/17.
 */
@Repository
public interface FeedbackRepository extends MongoRepository<Feedback, String> {

    @Query("{meetingId:'?0'}")
    public List<Feedback> findCustomByMeetingId(String meetingId);

}
