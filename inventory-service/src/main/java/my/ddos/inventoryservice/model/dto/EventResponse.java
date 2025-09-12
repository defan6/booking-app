package my.ddos.inventoryservice.model.dto;

public record EventResponse(String name,
                            Integer totalCapacity,
                            Integer leftCapacity,
                            Long venueId
) {
}
