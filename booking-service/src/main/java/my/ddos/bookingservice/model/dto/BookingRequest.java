package my.ddos.bookingservice.model.dto;

public record BookingRequest(Long customerId,
                             Long eventId,
                             Integer countTickets
) {
}
