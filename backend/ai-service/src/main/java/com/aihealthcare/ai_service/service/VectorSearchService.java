package com.aihealthcare.ai_service.service;

import com.aihealthcare.ai_service.entity.DocumentEmbedding;
import com.aihealthcare.ai_service.repository.DocumentEmbeddingRepository;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VectorSearchService {

    private final DocumentEmbeddingRepository repository;
    private final EmbeddingModel embeddingModel;

    public VectorSearchService(
            DocumentEmbeddingRepository repository,
            EmbeddingModel embeddingModel) {

        this.repository = repository;
        this.embeddingModel = embeddingModel;
    }

    public List<DocumentEmbedding> findRelevantDocuments(String question) {
        float[] queryEmbedding = embeddingModel.embed(question);
        return repository.findSimilarEmbeddings(queryEmbedding, 5);
    }

    public void saveDocumentEmbedding(Long documentId, String content, float[] embedding) {
        DocumentEmbedding doc = new DocumentEmbedding();
        doc.setDocumentId(documentId);
        doc.setContent(content);
        doc.setEmbedding(embedding);
        repository.save(doc);
    }
}