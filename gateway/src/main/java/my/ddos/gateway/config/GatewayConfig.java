package my.ddos.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {



    @Value("${order.service.url}")
    private String orderServiceUrl;

    @Value("${booking.service.url}")
    private String bookingServiceUrl;

    @Value("${inventory.service.url}")
    private String inventoryServiceUrl;

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("order-service", r -> r.path("/api/v1/orders/**")
                        .filters(f -> f.circuitBreaker(c -> c
                                        .setName("orders-circuit-breaker")
                                        .setFallbackUri("forward:/fallback/orders")
                                )
                        )
                        .uri(orderServiceUrl))
                .route("booking-service", r -> r.path("/api/v1/bookings/**")
                        .filters(f -> f.circuitBreaker(c -> c
                                        .setName("bookings-circuit-breaker")
                                        .setFallbackUri("forward:/fallback/bookings")
                                )
                        )
                        .uri(bookingServiceUrl))
                .route("inventory-service", r -> r.path("/api/v1/inventory/**")
                        .filters(f -> f.circuitBreaker(c -> c
                                        .setName("inventory-circuit-breaker")
                                        .setFallbackUri("forward:/fallback/inventory")
                                )
                        )
                        .uri(inventoryServiceUrl))
                .route("docs-inventory-service", r -> r.path("/docs/inventoryservice/v3/api-docs")
                        .filters(f -> f.stripPrefix(2))
                        .uri(inventoryServiceUrl))
                .route("docs-booking-service", r -> r.path("/docs/bookingsservice/v3/api-docs")
                        .filters(f -> f.stripPrefix(2))
                        .uri(bookingServiceUrl))
                .build();
    }
}
