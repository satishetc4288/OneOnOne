package com.cdk.oneonone.mongo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cdk.oneonone.mongo.Feedback;
import com.cdk.oneonone.mongo.Meeting;

import java.util.List;

/**
 * Created by rajputs on 7/18/17.
 */
public interface FeedbackRepository extends MongoRepository<Feedback, String> {

    @Query("{employeeid:'?0'}")
    public List<Feedback> findCustomByEmployee(String employeeid);

    @Query("{managerid:'?0'}")
    public List<Feedback> findCustomByManager(String managerid);

}
