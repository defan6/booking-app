package my.ddos.inventoryservice.mapper;


import my.ddos.inventoryservice.model.dto.EventResponse;
import my.ddos.inventoryservice.model.entity.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventResponse toResponse(Event event);
}
