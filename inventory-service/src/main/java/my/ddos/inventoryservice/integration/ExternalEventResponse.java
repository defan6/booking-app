package my.ddos.inventoryservice.integration;

import java.math.BigDecimal;

public record ExternalEventResponse(
        String name,
        Integer totalCapacity,
        Integer leftCapacity,
        Long venueId,
        BigDecimal tickerPrice
) {
}
