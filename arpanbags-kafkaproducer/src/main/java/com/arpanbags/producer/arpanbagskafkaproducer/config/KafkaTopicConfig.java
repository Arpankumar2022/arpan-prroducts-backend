package com.arpanbags.producer.arpanbagskafkaproducer.config;


import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;
import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class KafkaTopicConfig {

    private final KafkaTemplate<String, String>  kafkaTemplate;

    @Bean
    public NewTopic topicCreation() {
        return TopicBuilder
                .name("t.food.order")
                .partitions(1)
                .replicas(1)
                .build();
    }

}
