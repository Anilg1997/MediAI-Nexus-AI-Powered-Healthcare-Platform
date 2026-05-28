package com.aihealthcare.appointment_service.kafka;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;

@Service
public class AppointmentKafkaProducer {

    private final KafkaTemplate<String, String>
            kafkaTemplate;

    public AppointmentKafkaProducer(

            KafkaTemplate<String, String>
                    kafkaTemplate) {

        this.kafkaTemplate =
                kafkaTemplate;
    }

    public void sendAppointmentEvent(
            String message) {

        kafkaTemplate.send(

                "appointment-topic",

                message);
    }
}