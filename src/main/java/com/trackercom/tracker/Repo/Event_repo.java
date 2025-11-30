package com.trackercom.tracker.Repo;

import com.trackercom.tracker.Model.RawEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Event_repo extends MongoRepository<RawEvent, String> {
}