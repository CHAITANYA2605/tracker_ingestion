package com.trackercom.tracker.Services;
import com.trackercom.tracker.DTO.Events_Ingestion_DTO;
import com.trackercom.tracker.Model.*;
import com.trackercom.tracker.Repo.Event_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class IngestionService {
    @Autowired
    Event_repo repo;


    public void handleBatch(Events_Ingestion_DTO req, String appId) {

        String batchId = UUID.randomUUID().toString();
        Instant now = Instant.now();


        for (Events_Ingestion_DTO.EventItem ev : req.events) {

            RawEvent raw = new RawEvent();
            raw.setId(UUID.randomUUID().toString());
            raw.setBatchId(batchId);

            raw.setAppId(appId);
            raw.setUserId(req.userid);
            raw.setDeviceId(req.deviceid);

            raw.setEventName(ev.name);
            raw.setProperties(ev.properties);
            raw.setDeviceInfo(req.deviceinfo);

            raw.setIngestedAt(now);

            repo.save(raw);
        }
    }
}

