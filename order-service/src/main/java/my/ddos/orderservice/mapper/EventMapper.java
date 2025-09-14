package my.ddos.orderservice.mapper;


import my.ddos.orderservice.integration.kafka.event.EventKafkaBooking;
import my.ddos.orderservice.model.dto.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventMapper {


    @Mapping(target = "totalPrice", source = "totalPrice")
    @Mapping(target = "quantity", source = "ticketCount")
    @Mapping(target = "customerId", source = "customerId")
    @Mapping(target = "eventId", source = "eventId")
    OrderRequest fromEventKafkaBooking(EventKafkaBooking eventKafkaBooking);

}
