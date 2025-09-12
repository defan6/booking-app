package my.ddos.inventoryservice.service;


import my.ddos.inventoryservice.model.dto.EventResponse;

import java.util.List;

public interface InventoryService {

    List<EventResponse> getAllEvents();
}
