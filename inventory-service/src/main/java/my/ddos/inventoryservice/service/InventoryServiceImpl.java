package my.ddos.inventoryservice.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.ddos.inventoryservice.exception.EventNotFoundException;
import my.ddos.inventoryservice.exception.VenueNotFoundException;
import my.ddos.inventoryservice.integration.ExternalEventResponse;
import my.ddos.inventoryservice.mapper.EventMapper;
import my.ddos.inventoryservice.mapper.VenueMapper;
import my.ddos.inventoryservice.model.dto.EventResponse;
import my.ddos.inventoryservice.model.dto.VenueResponse;
import my.ddos.inventoryservice.model.entity.Event;
import my.ddos.inventoryservice.repository.EventRepository;
import my.ddos.inventoryservice.repository.VenueRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService{

    private final EventRepository eventRepository;

    private final VenueRepository venueRepository;

    private final EventMapper eventMapper;

    private final VenueMapper venueMapper;

    @Override
    public Page<EventResponse> getAllEvents(Pageable pageable) {
        return eventRepository
                .findAll(pageable)
                .map(eventMapper::toResponse);
    }

    @Override
    public VenueResponse getVenue(Long venueId) {
        return venueRepository.findById(venueId).map(venueMapper::toResponse)
                .orElseThrow(() -> new VenueNotFoundException("Venue with id " + venueId + " not found"));
    }

    @Override
    public ExternalEventResponse getEvent(Long eventId) {
        return eventRepository.findById(eventId)
                .map(eventMapper::toExternalResponse)
                .orElseThrow(() -> new EventNotFoundException("Event with id " + eventId + " not found"));
    }


    @Override
    public ExternalEventResponse updateEvent(Long eventId, Integer capacity) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event with id " + eventId + " not found"));
        event.setLeftCapacity(event.getLeftCapacity() - capacity);
        Event savedEvent = eventRepository.save(event);
        return eventMapper.toExternalResponse(savedEvent);
    }
}
