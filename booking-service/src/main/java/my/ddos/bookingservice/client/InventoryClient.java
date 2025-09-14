package my.ddos.bookingservice.client;


import my.ddos.bookingservice.integration.ExternalEventResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "inventory-service", url = "http://localhost:8081")
public interface InventoryClient {

    @GetMapping("/api/v1/inventory/events/{eventId}")
    ExternalEventResponse getEvent(@PathVariable Long eventId);


    @PutMapping("api/v1/inventory/event/{eventId}/capacity/{capacity}")
    ExternalEventResponse updateEvent(@PathVariable Long eventId,
                                      @PathVariable Integer capacity);

}
