package com.aihealthcare.payment_service.kafka;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;

@Service
public class PaymentKafkaProducer {

    private final KafkaTemplate<String, String>
            kafkaTemplate;

    public PaymentKafkaProducer(

            KafkaTemplate<String, String>
                    kafkaTemplate) {

        this.kafkaTemplate =
                kafkaTemplate;
    }

    public void sendPaymentEvent(
            String message) {

        kafkaTemplate.send(
                "payment-topic",
                message);
    }
}