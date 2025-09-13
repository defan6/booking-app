package my.ddos.bookingservice.model.dto;

public record CustomerResponse(Long id,
                               String name,
                               String email,
                               String address
) {
}
