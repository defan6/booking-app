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
                        .uri("http://localhost:8083"))
                .route("booking-service", r -> r.path("/api/v1/bookings/**")
                        .uri("http://localhost:8082"))
                .route("inventory-service", r -> r.path("/api/v1/inventory/**")
                        .filters(f -> f.addRequestHeader("X-Gateway", "SpringCloud"))
                        .uri("http://localhost:8081"))
                .build();
    }
}
