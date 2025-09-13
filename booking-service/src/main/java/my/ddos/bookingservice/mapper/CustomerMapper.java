package my.ddos.bookingservice.mapper;

import my.ddos.bookingservice.model.dto.CustomerResponse;
import my.ddos.bookingservice.model.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerResponse toResponse(Customer entity);
}
