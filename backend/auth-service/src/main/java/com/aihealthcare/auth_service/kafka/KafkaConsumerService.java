package com.aihealthcare.auth_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(
            topics = "user-registration-topic",
            groupId = "auth-group")
    public void consume(String message) {

        System.out.println(
                "Kafka Message Received: " + message);
    }
}