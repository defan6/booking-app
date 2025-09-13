package my.ddos.bookingservice.service;

import my.ddos.bookingservice.model.dto.BookingRequest;
import my.ddos.bookingservice.model.dto.BookingResponse;

public interface BookingService {


    BookingResponse createBooking(BookingRequest bookingRequest);
}
