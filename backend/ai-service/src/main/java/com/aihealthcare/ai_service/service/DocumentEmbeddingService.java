package com.aihealthcare.ai_service.service;

import com.aihealthcare.ai_service.entity.DocumentEmbedding;
import com.aihealthcare.ai_service.repository.DocumentEmbeddingRepository;

import org.springframework.stereotype.Service;

@Service
public class DocumentEmbeddingService {


    private final DocumentEmbeddingRepository
            repository;

    public DocumentEmbeddingService(
            DocumentEmbeddingRepository repository) {

        this.repository =
                repository;
    }

    public void saveEmbedding(
            Long documentId,
            String content,
            String embedding) {

        DocumentEmbedding doc =
                new DocumentEmbedding();

        doc.setDocumentId(
                documentId);

        doc.setContent(
                content);

        doc.setEmbedding(
                embedding);

        repository.save(doc);
    }


}
