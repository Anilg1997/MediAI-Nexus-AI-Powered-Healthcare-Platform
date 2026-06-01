package com.aihealthcare.ai_service.service;

import com.aihealthcare.ai_service.entity.DocumentData;
import com.aihealthcare.ai_service.repository.DocumentRepository;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DocumentService {


    private final DocumentRepository repository;

    private final EmbeddingService embeddingService;

    private final DocumentEmbeddingService
            documentEmbeddingService;

    public DocumentService(
            DocumentRepository repository,
            EmbeddingService embeddingService,
            DocumentEmbeddingService documentEmbeddingService) {

        this.repository = repository;
        this.embeddingService = embeddingService;
        this.documentEmbeddingService =
                documentEmbeddingService;
    }

    public void saveDocument(
            String fileName,
            String content) {

        DocumentData doc =
                new DocumentData();

        doc.setFileName(fileName);

        doc.setContent(content);

        DocumentData savedDoc =
                repository.save(doc);

        float[] vector =
                embeddingService.createEmbedding(
                        content);

        documentEmbeddingService
                .saveEmbedding(
                        savedDoc.getId(),
                        content,
                        Arrays.toString(vector));
    }


}
