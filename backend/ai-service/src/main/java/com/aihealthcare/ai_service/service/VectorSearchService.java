package com.aihealthcare.ai_service.service;

import com.aihealthcare.ai_service.entity.DocumentEmbedding;
import com.aihealthcare.ai_service.repository.DocumentEmbeddingRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VectorSearchService {

    private final DocumentEmbeddingRepository
            repository;

    public VectorSearchService(
            DocumentEmbeddingRepository repository) {

        this.repository =
                repository;
    }

    public List<DocumentEmbedding>
    findRelevantDocuments(
            String question) {

        // Placeholder
        // Later replace with
        // pgvector similarity search

        return repository
                .findTop5ByOrderByIdDesc();
    }
}