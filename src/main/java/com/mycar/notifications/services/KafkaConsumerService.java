package com.mycar.notifications.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumerService {

    @Value("${KAFKA_TOPIC_NAME}")
    private String topicName;

    private String TOPIC;

    @PostConstruct
    private void initialize() {
        this.TOPIC = topicName;
    }

    @KafkaListener(topics = "#{@kafkaConsumerService.TOPIC}", groupId = "my-consumer-group")
    public void consumeMessage(String message) {
        System.out.println("Mensaje recibido: " + message);
        // Procesar el mensaje aquí
    }
}


