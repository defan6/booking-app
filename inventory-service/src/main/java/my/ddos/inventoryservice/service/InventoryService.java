package my.ddos.inventoryservice.service;


import my.ddos.inventoryservice.integration.ExternalEventResponse;
import my.ddos.inventoryservice.model.dto.EventResponse;
import my.ddos.inventoryservice.model.dto.VenueResponse;

import java.util.List;

public interface InventoryService {

    List<EventResponse> getAllEvents();

    VenueResponse getVenue(Long venueId);

    ExternalEventResponse getEvent(Long eventId);

    ExternalEventResponse updateEvent(Long eventId, Integer capacity);
}
