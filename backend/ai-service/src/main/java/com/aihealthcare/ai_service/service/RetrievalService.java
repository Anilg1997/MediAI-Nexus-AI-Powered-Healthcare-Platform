package com.aihealthcare.ai_service.service;

import com.aihealthcare.ai_service.entity.DocumentEmbedding;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetrievalService {

    private final VectorSearchService
            vectorSearchService;

    public RetrievalService(
            VectorSearchService vectorSearchService) {

        this.vectorSearchService =
                vectorSearchService;
    }

    public List<DocumentEmbedding>
    retrieveTopDocuments(
            String question) {

        return vectorSearchService
                .findRelevantDocuments(
                        question);
    }
}