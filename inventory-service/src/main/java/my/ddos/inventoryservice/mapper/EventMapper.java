package my.ddos.inventoryservice.mapper;


import my.ddos.inventoryservice.integration.ExternalEventResponse;
import my.ddos.inventoryservice.model.dto.EventResponse;
import my.ddos.inventoryservice.model.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventMapper {

    @Mapping(target = "venueId", source = "venue.id")
    EventResponse toResponse(Event entity);

    @Mapping(target = "venueId", source = "venue.id")
    ExternalEventResponse toExternalResponse(Event entity);
}
