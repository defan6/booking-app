package my.ddos.inventoryservice.controller;


import lombok.RequiredArgsConstructor;
import my.ddos.inventoryservice.model.dto.EventResponse;
import my.ddos.inventoryservice.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class InventoryController {

    private final InventoryService inventoryService;


    @GetMapping
    public ResponseEntity<List<EventResponse>> getAllEvents(){
        return ResponseEntity.ok(inventoryService.getAllEvents());
    }
}
