package my.ddos.bookingservice.service;

import my.ddos.bookingservice.model.dto.CustomerResponse;

public interface CustomerService {
    CustomerResponse getCustomer(Long customerId);
}
