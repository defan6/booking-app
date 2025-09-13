package my.ddos.bookingservice.exception;

public class NotEnoughTickets extends RuntimeException {
    public NotEnoughTickets(String message) {
        super(message);
    }
}
