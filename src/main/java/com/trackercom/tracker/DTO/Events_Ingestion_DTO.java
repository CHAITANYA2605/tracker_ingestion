package com.trackercom.tracker.DTO;

import java.util.List;
import java.util.Map;

public class Events_Ingestion_DTO {
    public String userid;
    public String deviceid;
    public Map<String, Object> deviceinfo;
    public List<EventItem> events;

    public static class EventItem {
        public String name;
        public Map<String, Object> properties;
        public Long timestamp;
        public String time;
    }
}
