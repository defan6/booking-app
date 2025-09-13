package my.ddos.bookingservice.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {


    @Bean
    public NewTopic createOrderTopic(){
        return TopicBuilder.name("order-topic")
                .partitions(3)
                .replicas(1)
                .build();
    }
}
