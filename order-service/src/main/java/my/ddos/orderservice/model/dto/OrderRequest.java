package my.ddos.orderservice.model.dto;

import java.math.BigDecimal;

public record OrderRequest
        (
                BigDecimal totalPrice,
                Integer quantity,
                Long customerId,
                Long eventId
        ) {
}
