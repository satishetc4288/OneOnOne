package com.cdk.springboot.mongo.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cdk.springboot.mongo.Meeting;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rajputs on 7/17/17.
 */
@Repository
public interface MeetingRepository extends MongoRepository<Meeting, String>{

    @Query("{sender:'?0'}")
    public List<Meeting> findCustomBySender(String sender);

    @Query("{receiver:'?0'}")
    public List<Meeting> findCustomByReceiver(String receiver);

}
