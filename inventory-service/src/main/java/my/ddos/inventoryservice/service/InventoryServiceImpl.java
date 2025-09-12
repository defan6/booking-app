package my.ddos.inventoryservice.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.ddos.inventoryservice.mapper.EventMapper;
import my.ddos.inventoryservice.model.dto.EventResponse;
import my.ddos.inventoryservice.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService{

    private final EventRepository eventRepository;

    private final EventMapper eventMapper;

    @Override
    public List<EventResponse> getAllEvents() {
        return eventRepository
                .findAll()
                .stream()
                .map(eventMapper::toResponse)
                .toList();
    }
}
