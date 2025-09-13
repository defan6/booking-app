package my.ddos.bookingservice.integration;

import java.math.BigDecimal;

public record ExternalEventResponse(
        String name,
        Integer totalCapacity,
        Integer leftCapacity,
        Long venueId,
        BigDecimal ticketPrice

) {
}
