package com.aihealthcare.doctor_service.kafka;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;

@Service
public class DoctorKafkaProducer {

    private final KafkaTemplate<String, String>
            kafkaTemplate;

    public DoctorKafkaProducer(

            KafkaTemplate<String, String>
                    kafkaTemplate) {

        this.kafkaTemplate =
                kafkaTemplate;
    }

    public void sendDoctorEvent(
            String message) {

        kafkaTemplate.send(

                "doctor-topic",

                message);
    }
}