package my.ddos.orderservice.integration.kafka.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.ddos.orderservice.integration.kafka.event.EventKafkaBooking;
import my.ddos.orderservice.mapper.EventMapper;
import my.ddos.orderservice.model.dto.OrderRequest;
import my.ddos.orderservice.service.OrderService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

    private final OrderService orderService;

    private final EventMapper eventMapper;

    @KafkaListener(topics = "order-topic", groupId = "order_group")
    public void consumeEventKafkaBooking(EventKafkaBooking eventKafkaBooking) {
        OrderRequest orderRequest = eventMapper.fromEventKafkaBooking(eventKafkaBooking);
        orderService.placeOrder(orderRequest);
        log.info("Placed order: {}", orderRequest);
    }
}
