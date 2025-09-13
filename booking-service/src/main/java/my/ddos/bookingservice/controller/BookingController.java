package my.ddos.bookingservice.controller;

import lombok.RequiredArgsConstructor;
import my.ddos.bookingservice.model.dto.BookingRequest;
import my.ddos.bookingservice.model.dto.BookingResponse;
import my.ddos.bookingservice.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BookingController {

    private final BookingService bookingService;


    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(@RequestBody BookingRequest bookingRequest){
        return ResponseEntity.ok(bookingService.createBooking(bookingRequest));
    }
}
