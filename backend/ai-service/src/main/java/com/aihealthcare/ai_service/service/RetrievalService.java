package com.aihealthcare.ai_service.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RetrievalService {

    private final VectorStore vectorStore;

    public RetrievalService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    public List<Document> retrieveTopDocuments(String question) {
        return vectorStore.similaritySearch(question);
    }

    public List<Document> retrieveTopDocuments(String question, int k) {
        return vectorStore.similaritySearch(question, k);
    }
}