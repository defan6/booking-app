package my.ddos.orderservice.mapper;


import my.ddos.orderservice.model.dto.OrderRequest;
import my.ddos.orderservice.model.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toEntity(OrderRequest orderRequest);
}
