package my.ddos.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {


    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("order-service", r -> r.path("/api/v1/orders/**")
                        .filters(f -> f.circuitBreaker(c -> c
                                        .setName("orders-circuit-breaker")
                                        .setFallbackUri("forward:/fallback/orders")
                                )
                        )
                        .uri("http://localhost:8083"))
                .route("booking-service", r -> r.path("/api/v1/bookings/**")
                        .filters(f -> f.circuitBreaker(c -> c
                                        .setName("bookings-circuit-breaker")
                                        .setFallbackUri("forward:/fallback/bookings")
                                )
                        )
                        .uri("http://localhost:8082"))
                .route("inventory-service", r -> r.path("/api/v1/inventory/**")
                        .filters(f -> f.circuitBreaker(c -> c
                                        .setName("inventory-circuit-breaker")
                                        .setFallbackUri("forward:/fallback/inventory")
                                )
                        )
                        .uri("http://localhost:8081"))
                .route("docs-inventory-service", r -> r.path("/docs/inventoryservice/v3/api-docs")
                        .filters(f -> f.stripPrefix(2))
                        .uri("http://localhost:8081"))
                .route("docs-booking-service", r -> r.path("/docs/bookingsservice/v3/api-docs")
                        .filters(f -> f.stripPrefix(2))
                        .uri("http://localhost:8082"))
                .build();
    }
}
