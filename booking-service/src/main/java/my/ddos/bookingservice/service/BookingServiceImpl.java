package my.ddos.bookingservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.ddos.bookingservice.client.InventoryClient;
import my.ddos.bookingservice.exception.NotEnoughTickets;
import my.ddos.bookingservice.integration.ExternalEventResponse;
import my.ddos.bookingservice.integration.kafka.event.EventKafkaBooking;
import my.ddos.bookingservice.integration.kafka.service.KafkaProducer;
import my.ddos.bookingservice.model.dto.BookingRequest;
import my.ddos.bookingservice.model.dto.BookingResponse;
import my.ddos.bookingservice.model.dto.CustomerResponse;
import my.ddos.bookingservice.model.entity.Customer;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
@Slf4j
public class BookingServiceImpl implements BookingService{

    private final CustomerService customerService;

    private final InventoryClient inventoryClient;


    private final KafkaProducer kafkaProducer;

    @Override
    public BookingResponse createBooking(BookingRequest bookingRequest) {
        CustomerResponse customerResponse = customerService.getCustomer(bookingRequest.customerId());
        ExternalEventResponse externalEventResponse = inventoryClient.getEvent(bookingRequest.eventId());
        if(externalEventResponse.leftCapacity() < bookingRequest.countTickets()){
            throw new NotEnoughTickets("Not enough tickets: left - " + externalEventResponse.leftCapacity()
            + " you need " + bookingRequest.countTickets());
        }
        BigDecimal totalPrice = externalEventResponse.ticketPrice().multiply(BigDecimal.valueOf(bookingRequest.countTickets()));
        EventKafkaBooking eventKafkaBooking = new EventKafkaBooking(
                bookingRequest.customerId(),
                bookingRequest.eventId(),
                bookingRequest.countTickets(),
                totalPrice);
        kafkaProducer.sendBookingEvent(eventKafkaBooking);
        return new BookingResponse(customerResponse.name(),
                externalEventResponse.name(),
                externalEventResponse.venueId(),
                totalPrice
        );
    }
}
