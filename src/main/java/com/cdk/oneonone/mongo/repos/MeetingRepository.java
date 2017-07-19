package com.cdk.oneonone.mongo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cdk.oneonone.mongo.Meeting;

import java.util.List;

/**
 * Created by rajputs on 7/17/17.
 */

public interface MeetingRepository extends MongoRepository<Meeting, String>{

    @Query("{sender:'?0'}")
    public List<Meeting> findCustomBySender(String sender);

    @Query("{receiver:'?0'}")
    public List<Meeting> findCustomByReceiver(String receiver);

}
