package my.ddos.orderservice.integration.kafka.event;

import java.math.BigDecimal;

public record EventKafkaBooking
        (
                Long customerId,
                Long eventId,
                Integer ticketCount,
                BigDecimal totalPrice
        ) {
}
