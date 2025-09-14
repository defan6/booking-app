package my.ddos.gateway;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @RequestMapping("/orders")
    public ResponseEntity<String> ordersFallback() {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Order Service is temporarily unavailable. Please try again later.");
    }

    @RequestMapping("/bookings")
    public ResponseEntity<String> bookingsFallback() {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Booking Service is temporarily unavailable. Please try again later.");
    }

    @RequestMapping("/inventory")
    public ResponseEntity<String> inventoryFallback() {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Inventory Service is temporarily unavailable. Please try again later.");
    }
}
