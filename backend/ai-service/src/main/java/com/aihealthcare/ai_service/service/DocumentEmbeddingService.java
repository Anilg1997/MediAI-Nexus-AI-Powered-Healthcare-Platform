package com.aihealthcare.ai_service.service;

import com.aihealthcare.ai_service.entity.DocumentEmbedding;
import com.aihealthcare.ai_service.repository.DocumentEmbeddingRepository;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.stereotype.Service;

@Service
public class DocumentEmbeddingService {

    private final DocumentEmbeddingRepository repository;
    private final EmbeddingModel embeddingModel;

    public DocumentEmbeddingService(
            DocumentEmbeddingRepository repository,
            EmbeddingModel embeddingModel) {

        this.repository = repository;
        this.embeddingModel = embeddingModel;
    }

    public void saveEmbedding(Long documentId, String content) {
        float[] embedding = embeddingModel.embed(content);

        DocumentEmbedding doc = new DocumentEmbedding();
        doc.setDocumentId(documentId);
        doc.setContent(content);
        doc.setEmbedding(embedding);

        repository.save(doc);
    }

    public void saveEmbedding(Long documentId, String content, float[] embedding) {
        DocumentEmbedding doc = new DocumentEmbedding();
        doc.setDocumentId(documentId);
        doc.setContent(content);
        doc.setEmbedding(embedding);
        repository.save(doc);
    }
}