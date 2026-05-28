package com.aihealthcare.auth_service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC =
            "user-registration-topic";

    public void sendMessage(String message) {

        kafkaTemplate.send(TOPIC, message);
    }
}