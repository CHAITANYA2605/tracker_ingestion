package com.trackercom.tracker.Controllers;


import com.trackercom.tracker.DTO.Events_Ingestion_DTO;
import com.trackercom.tracker.Services.IngestionService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class Ingestion_controller {

        @Autowired
        private IngestionService ingestionService;

        @PostMapping("/ingest")
        public ResponseEntity<?> ingest(@RequestBody Events_Ingestion_DTO req,
                                        @RequestHeader("x-app-id") String appId) {

            if (req.events == null || req.events.isEmpty()) {
                return ResponseEntity.badRequest().body("Events array cannot be empty");
            }

            ingestionService.handleBatch(req, appId);
            return ResponseEntity.ok().build();
        }

}
