package com.trackercom.tracker.Services;
import com.trackercom.tracker.DTO.Events_Ingestion_DTO;
import com.trackercom.tracker.Model.*;
import com.trackercom.tracker.Repo.Event_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Service
public class IngestionService {
    @Autowired
    Event_repo repo;


    public void handleBatch(Events_Ingestion_DTO req, String appId) {

        String batchId = UUID.randomUUID().toString();
        Instant now = Instant.now();
        ArrayList<RawEvent> value=new ArrayList<>();

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
            value.add(raw);
        }
        repo.saveAll(value);
        System.out.println("akjsbjaskbdjkasbdjasbd+"+value.size());
    }
}

