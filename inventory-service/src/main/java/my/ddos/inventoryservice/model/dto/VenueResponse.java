package my.ddos.inventoryservice.model.dto;

import java.util.List;

public record VenueResponse(String name,
                            Integer totalCapacity,
                            List<EventResponse> eventResponses
) {
}
