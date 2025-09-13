package my.ddos.inventoryservice.mapper;


import my.ddos.inventoryservice.model.dto.VenueResponse;
import my.ddos.inventoryservice.model.entity.Venue;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VenueMapper {

    VenueResponse toResponse(Venue entity);
}
