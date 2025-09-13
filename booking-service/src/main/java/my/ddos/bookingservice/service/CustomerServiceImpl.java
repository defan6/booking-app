package my.ddos.bookingservice.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.ddos.bookingservice.exception.CustomerNotFoundException;
import my.ddos.bookingservice.mapper.CustomerMapper;
import my.ddos.bookingservice.model.dto.CustomerResponse;
import my.ddos.bookingservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse getCustomer(Long customerId) {
        return customerRepository.findById(customerId)
                .map(customerMapper::toResponse)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id " + customerId + " not found"));
    }
}
