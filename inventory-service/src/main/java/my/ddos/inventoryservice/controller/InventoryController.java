package my.ddos.inventoryservice.controller;


import lombok.RequiredArgsConstructor;
import my.ddos.inventoryservice.model.dto.VenueResponse;
import my.ddos.inventoryservice.model.dto.EventResponse;
import my.ddos.inventoryservice.integration.ExternalEventResponse;
import my.ddos.inventoryservice.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    private final InventoryService inventoryService;


    @GetMapping("/events")
    public ResponseEntity<List<EventResponse>> getAllEvents(){
        return ResponseEntity.ok(inventoryService.getAllEvents());
    }


    @GetMapping("/venues/{venueId}")
    public ResponseEntity<VenueResponse> getVenue(@PathVariable("venueId") Long venueId){
        return ResponseEntity.ok(inventoryService.getVenue(venueId));
    }


    @GetMapping("/events/{eventId}")
    public ResponseEntity<ExternalEventResponse> getEvent(@PathVariable("eventId") Long eventId){
        return ResponseEntity.ok(inventoryService.getEvent(eventId));
    }


    @PutMapping("/event/{eventId}/capacity/{capacity}")
    public ResponseEntity<ExternalEventResponse> updateEvent(@PathVariable("eventId") Long eventId,
                                                     @PathVariable("capacity") Integer capacity){
        return ResponseEntity.ok(inventoryService.updateEvent(eventId, capacity));
    }
}
