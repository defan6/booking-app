package my.ddos.inventoryservice.mapper;


import my.ddos.inventoryservice.model.dto.VenueResponse;
import my.ddos.inventoryservice.model.entity.Venue;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EventMapper.class})
public interface VenueMapper {

    @Mapping(target = "eventResponses", source = "events")
    VenueResponse toResponse(Venue entity);
}
