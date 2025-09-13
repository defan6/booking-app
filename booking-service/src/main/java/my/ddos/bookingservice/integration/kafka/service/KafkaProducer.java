package my.ddos.bookingservice.integration.kafka.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.ddos.bookingservice.integration.kafka.event.EventKafkaBooking;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendBookingEvent(EventKafkaBooking eventKafkaBooking){
        Message<Object> kafkaMessage = buildMessage(eventKafkaBooking);
        kafkaTemplate.send(kafkaMessage);
        log.info("Send message: {}, to topic {}", kafkaMessage, "order-service");
    }

    private static Message<Object> buildMessage(Object object){
        return MessageBuilder.withPayload(object)
                .setHeader(KafkaHeaders.TOPIC, "order-topic")
                .build();
    }
}
