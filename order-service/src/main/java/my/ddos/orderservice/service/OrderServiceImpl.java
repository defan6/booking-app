package my.ddos.orderservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.ddos.orderservice.client.InventoryClient;
import my.ddos.orderservice.mapper.OrderMapper;
import my.ddos.orderservice.model.dto.OrderRequest;
import my.ddos.orderservice.model.entity.Order;
import my.ddos.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    private final InventoryClient inventoryClient;

    private final OrderMapper orderMapper;
    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order = orderMapper.toEntity(orderRequest);
        inventoryClient.updateEvent(orderRequest.eventId(), orderRequest.quantity());
        orderRepository.save(order);
    }
}
