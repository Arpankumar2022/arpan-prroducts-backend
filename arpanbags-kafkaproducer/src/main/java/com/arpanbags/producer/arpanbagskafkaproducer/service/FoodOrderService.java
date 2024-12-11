package com.arpanbags.producer.arpanbagskafkaproducer.service;

import com.arpanbags.producer.arpanbagskafkaproducer.config.OrderKafkaProducer;
import com.arpanbags.producer.arpanbagskafkaproducer.model.FoodOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FoodOrderService {

    private final OrderKafkaProducer orderKafkaProducer;


    public String createFoodOrder(FoodOrder foodOrder) throws JsonProcessingException {
        return orderKafkaProducer.sendMessage(foodOrder);
    }
}