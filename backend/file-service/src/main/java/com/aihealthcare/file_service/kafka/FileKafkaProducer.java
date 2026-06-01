package com.aihealthcare.file_service.kafka;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;

@Service
public class FileKafkaProducer {

    private final KafkaTemplate<String, String>
            kafkaTemplate;

    public FileKafkaProducer(
            KafkaTemplate<String, String>
                    kafkaTemplate) {

        this.kafkaTemplate =
                kafkaTemplate;
    }

    public void sendFileEvent(
            String filePath) {

        kafkaTemplate.send(
                "file-topic",
                filePath);
    }
}