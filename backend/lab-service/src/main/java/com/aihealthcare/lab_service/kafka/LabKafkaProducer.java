package com.aihealthcare.lab_service.kafka;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;

@Service
public class LabKafkaProducer {

    private final KafkaTemplate<String, String>
            kafkaTemplate;

    public LabKafkaProducer(

            KafkaTemplate<String, String>
                    kafkaTemplate) {

        this.kafkaTemplate =
                kafkaTemplate;
    }

    public void sendLabEvent(
            String message) {

        kafkaTemplate.send(
                "lab-topic",
                message);
    }
}