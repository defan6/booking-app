package my.ddos.inventoryservice.model.dto;

import java.math.BigDecimal;

public record EventResponse(
        String name,
        Integer totalCapacity,
        Integer leftCapacity,
        Long venueId,
        BigDecimal ticketPrice
) {
}
