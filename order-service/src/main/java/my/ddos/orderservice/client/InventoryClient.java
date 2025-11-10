package my.ddos.orderservice.client;

import my.ddos.orderservice.integration.dto.ExternalEventResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "inventory-service", url = "${inventory.service.client:http://localhost:7081}")
public interface InventoryClient {

    @PutMapping("api/v1/inventory/event/{eventId}/capacity/{capacity}")
    ExternalEventResponse updateEvent(@PathVariable Long eventId,
                                      @PathVariable Integer capacity);

}
