package my.ddos.orderservice.client;

import my.ddos.orderservice.integration.dto.ExternalEventResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "inventory-service", url = "http://localhost:8080")
public interface InventoryClient {

    @PutMapping("api/v1/inventory/event/{eventId}/capacity/{capacity}")
    ExternalEventResponse updateEvent(@PathVariable Long eventId,
                                      @PathVariable Integer capacity);

}
