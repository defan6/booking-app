package my.ddos.inventoryservice.service;


import my.ddos.inventoryservice.integration.ExternalEventResponse;
import my.ddos.inventoryservice.model.dto.EventResponse;
import my.ddos.inventoryservice.model.dto.VenueResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InventoryService {

    Page<EventResponse> getAllEvents(Pageable pageable);

    VenueResponse getVenue(Long venueId);

    ExternalEventResponse getEvent(Long eventId);

    ExternalEventResponse updateEvent(Long eventId, Integer capacity);
}
