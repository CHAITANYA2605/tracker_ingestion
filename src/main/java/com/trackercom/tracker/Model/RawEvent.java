package com.trackercom.tracker.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Map;


@Data
@Document(collection = "user_events")
public class RawEvent {


    @Id
    private String id; // uuid string


    private String appId;
    private String userId;
    private String deviceId;
    private String eventName;


    private Map<String, Object> properties; // dynamic event properties


    private Map<String, Object> deviceInfo; // device metadata

    private Boolean processed = false;
    private Instant processedAt;
    private Instant ingestedAt;
    private String batchId;
}
