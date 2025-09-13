package my.ddos.bookingservice.model.dto;

import java.math.BigDecimal;

public record BookingResponse(String customerName,
                              String eventName,
                              Long venueId,
                              BigDecimal totalPrice
) {
}
