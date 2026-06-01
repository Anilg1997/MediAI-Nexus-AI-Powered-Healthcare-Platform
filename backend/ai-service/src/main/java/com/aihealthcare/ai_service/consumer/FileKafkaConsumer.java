package com.aihealthcare.ai_service.consumer;

import com.aihealthcare.ai_service.service.PdfExtractionService;

import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Service;

@Service
public class FileKafkaConsumer {

    private final PdfExtractionService
            pdfService;

    public FileKafkaConsumer(
            PdfExtractionService pdfService) {

        this.pdfService =
                pdfService;
    }

    @KafkaListener(
            topics = "file-topic",
            groupId = "ai-group")

    public void consumeFileEvent(
            String filePath) {

        try {

            System.out.println(
                    "Received File Event: "
                            + filePath);

            String content =
                    pdfService.extractText(
                            filePath);

            System.out.println(
                    "PDF CONTENT:");

            System.out.println(content);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}