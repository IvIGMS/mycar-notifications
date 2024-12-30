package com.mycar.notifications.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mycar.notifications.entities.EmailNotificationEntity;
import com.mycar.notifications.utils.JsonDeserializer;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "${KAFKA_TOPIC_NAME}", groupId = "my-consumer-group")
    public void consumeMessage(String message) {
        log.info("Message received: {}", message);

        try {
            EmailNotificationEntity object = JsonDeserializer.deserialize(message, EmailNotificationEntity.class);
            // Aquí la lógica para enviar emails
            log.info("No se están enviando los correos, falta implementar esta parte.");
        } catch (JsonProcessingException e) {
            log.error("Error deserializando JSON: {}", e.getMessage());
        }

    }
}



